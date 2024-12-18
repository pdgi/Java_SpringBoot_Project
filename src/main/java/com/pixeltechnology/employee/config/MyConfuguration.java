package com.pixeltechnology.employee.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfuguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
