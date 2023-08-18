package co.jp.supercompany.library;

import co.jp.supercompany.library.service.DBWrapper;
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
