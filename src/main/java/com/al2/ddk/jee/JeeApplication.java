package com.al2.ddk.jee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JeeApplication {

	public static void main(String[] args) {
        SpringApplication.run(JeeApplication.class, args);
    }

}
