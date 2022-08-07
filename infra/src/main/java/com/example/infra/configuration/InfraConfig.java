package com.example.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@ComponentScan(basePackages = "com.example.infra")
public class InfraConfig {

  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(true);
    filter.setIncludeClientInfo(true);
    filter.setIncludePayload(true);
    filter.setMaxPayloadLength(6400);
    return filter;
  }

}
