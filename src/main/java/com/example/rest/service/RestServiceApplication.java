package com.example.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.*" })
@EnableJpaRepositories(basePackages = "com.example.service.repository")
@EntityScan("com.example.business")
public class RestServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
