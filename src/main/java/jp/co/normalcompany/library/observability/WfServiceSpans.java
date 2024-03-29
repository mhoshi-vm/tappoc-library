package jp.co.normalcompany.library.observability;

import brave.handler.MutableSpan;
import brave.handler.SpanHandler;
import brave.propagation.TraceContext;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.StringReader;

@Configuration
public class WfServiceSpans {

    public final String dbType;

    public final String dbInstance;

    public final String appName;

    public final String inboundServiceType;

    private final String socialOrigin;

    Logger logger = LoggerFactory.getLogger(WfServiceSpans.class);

    CCJSqlParserManager ccjSqlParserManager;

    TablesNamesFinder tablesNamesFinder;

    Statement statement;

    public WfServiceSpans(@Value("${db.type:localdb}") String dbType, @Value("${db.instance:local}") String dbInstance,
                          @Value("${app.name}") String appName,
                          @Value("${inboundExternalService.serviceType:LB}") String inboundServiceType,
                          @Value("${social.origin:Social}") String socialOrigin) {

        this.dbType = dbType;
        this.dbInstance = dbInstance;
        this.appName = appName;
        this.ccjSqlParserManager = new CCJSqlParserManager();
        this.tablesNamesFinder = new TablesNamesFinder();
        this.inboundServiceType = inboundServiceType;
        this.socialOrigin = socialOrigin;

    }

    @Bean
    SpanHandler spanDebugHandler() {

        return new SpanHandler() {
            @Override
            public boolean end(TraceContext traceContext, MutableSpan span, Cause cause) {
                logger.debug("New Span!!");
                logger.debug("Span name : " + span.name());
                logger.debug("Span kind : " + span.kind());
                logger.debug("Span Remote Source :" + span.remoteServiceName());
                span.tags().forEach((key, value) -> logger.debug("     tag :" + key + " value: " + value));
                return true;
            }
        };
    }

    @Bean
    SpanHandler spanServiceHandler() {
        return new SpanHandler() {
            @Override
            public boolean end(TraceContext traceContext, MutableSpan span, Cause cause) {

                for (int i = 0; i < span.tagCount(); i++) {
                    if (span.tagKeyAt(i).startsWith("jdbc.query")) {
                        try {
                            statement = ccjSqlParserManager.parse(new StringReader(span.tagValueAt(i)));
                            logger.debug("Sending trace to table :" + tablesNamesFinder.getTableList(statement).get(0));
                        }
                        catch (JSQLParserException e) {
                            logger.warn("Unable to parse SQL");
                            return false;
                        }
                        span.tag("_outboundExternalService", tablesNamesFinder.getTableList(statement).get(0));
                        if (dbInstance.equals("Greenplum DB")) {
                            span.tag("_externalApplication", dbInstance);
                        }
                        else {
                            span.tag("_externalApplication", appName);
                        }
                        span.tag("_externalComponent", dbType);
                    }
                }
                return true;
            }
        };
    }

}
