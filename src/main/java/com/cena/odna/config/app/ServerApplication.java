package com.cena.odna.config.app;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by Admin on 21.12.2016.
 */
@SpringBootApplication
@ComponentScan("com.cena.odna.*")
@CrossOrigin(origins = "http://localhost:3000")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://127.0.0.1:5432/CENA_ODNA");
        ds.setUsername("cenaodna");
        ds.setPassword("919293");
        return ds;
    }

}
