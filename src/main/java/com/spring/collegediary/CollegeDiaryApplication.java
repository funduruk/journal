package com.spring.collegediary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.spring.collegediary.model")
public class CollegeDiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeDiaryApplication.class, args);
    }

}
