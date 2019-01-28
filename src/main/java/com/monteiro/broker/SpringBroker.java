package com.monteiro.broker;

import static org.springframework.boot.SpringApplication.run;
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
        run(SpringBroker.class, args);
    }
}
