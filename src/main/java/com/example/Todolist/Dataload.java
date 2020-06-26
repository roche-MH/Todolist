package com.example.Todolist;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import ch.qos.logback.core.joran.action.AppenderAction;

public interface TodolistService extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationArguments.class, args);
    }

    default SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppenderAction.class);
    }

}