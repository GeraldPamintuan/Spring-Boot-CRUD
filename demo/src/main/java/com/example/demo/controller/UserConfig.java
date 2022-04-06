//package com.example.demo.controller;
//
//import com.example.demo.entity.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(
//            UserRepository repository){
//        return args -> {
//            User admin = new User(
//                    "Admin",
//                    "Spring Boot Exercise",
//                    LocalDate.of(2022, Month.APRIL, 8).toString()
//            );
//            User gerald = new User(
//                    "Gerald",
//                    "Spring Boot Exercise",
//                    LocalDate.of(2022, Month.APRIL, 6).toString()
//            );
//
//            repository.saveAll(List.of(
//                    admin, gerald)
//            );
//        };
//    }
//}
