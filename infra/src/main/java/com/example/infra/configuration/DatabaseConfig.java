package com.example.infra.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.example.infra.database.entity")
public class DatabaseConfig {

}
