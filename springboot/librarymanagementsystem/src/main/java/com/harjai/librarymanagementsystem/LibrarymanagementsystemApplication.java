package com.harjai.librarymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.harjai.librarymanagementsystem")
public class LibrarymanagementsystemApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(LibrarymanagementsystemApplication.class, args);
    }

}
