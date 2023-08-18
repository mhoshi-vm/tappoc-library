package jp.co.normalcompany.library;

import jp.co.normalcompany.library.service.DBWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {


    DBWrapper dbWrapper;

    public LibraryApplication(DBWrapper dbWrapper) {
        this.dbWrapper = dbWrapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public void helloLibrary(){
        dbWrapper.listPerson().forEach(n-> System.out.println(n.toString())
        );
    }

}
