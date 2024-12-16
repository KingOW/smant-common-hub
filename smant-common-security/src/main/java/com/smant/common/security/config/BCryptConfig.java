package com.smant.common.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ConditionalOnProperty(name = "smant.security.bcrypt.enable",havingValue="true")
public class BCryptConfig {

    @Value("${smant.security.bcrypt.strength:9}")
    private int strength;
    @Bean(value = "bcryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
       return passwordEncoder;
    }
}
