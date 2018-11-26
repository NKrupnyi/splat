package com.krupnyi.splat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SplatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplatApplication.class, args);
    }
}
