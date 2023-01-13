package com.cvetkov.fedor.laboratoryworkmicro.concerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.cvetkov.fedor.laboratoryworkmicro"})
@EnableJpaRepositories(basePackages = {"com.cvetkov.fedor.laboratoryworkmicro.concerts"})
@EnableFeignClients
public class ConcertsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcertsApplication.class, args);
    }

}
