package com.tinnova.tinnovaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TinnovaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinnovaprojectApplication.class, args);
    }

}
