package com.example.data_analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DataAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAnalysisApplication.class, args);
    }

}
