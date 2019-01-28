package com.monteiro.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author vicente.monteiro
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class SpringBroker {

    public static void main(String[] args) {
        SpringApplication.run(SpringBroker.class, args);
    }
}
