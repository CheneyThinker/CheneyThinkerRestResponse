package com.cheney.thinker.response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description
 * author CheneyThinker
 * date 2018-06-11
 */
@SpringBootApplication
public class ResponseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResponseApplication.class, args);
        System.err.println("ResponseApplication is Running!");
    }
}
