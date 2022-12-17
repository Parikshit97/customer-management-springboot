package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@ComponentScan(basePackages = "com.example")
@EnableAutoConfiguration
@Configuration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public greetResponse greet() {
        return new greetResponse("Hello",
                List.of("Java", "C#"),
                new Person("Parikshit Narang", 25, Double.MIN_VALUE));
    }

    record Person(String person, int age, double savings){

    }

    record greetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){

    }
}
