package com.project.bit.api;

import com.project.bit.api.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class ProjectBitApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBitApiApplication.class, args);
    }

}
