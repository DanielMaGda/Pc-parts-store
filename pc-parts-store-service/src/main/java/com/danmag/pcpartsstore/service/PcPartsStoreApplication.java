package com.danmag.pcpartsstore.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

@SpringBootApplication
public class PcPartsStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcPartsStoreApplication.class, args);

    }



}
