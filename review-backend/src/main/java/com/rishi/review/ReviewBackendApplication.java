package com.rishi.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ReviewBackendApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(ReviewBackendApplication.class, args);
        System.out.println("🎬 Movie Review API is Running!");
    }
}
