package com.ingg.reports.dailystatusreport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ReportsMvcConfiguration implements WebMvcConfigurer {

    Logger logger = LoggerFactory.getLogger(ReportsMvcConfiguration.class);

    @Value("${screenshots.location}")
    private String location;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("AAAAAAAAa {}",location);
        registry.addResourceHandler("/screenshots/**")
                .addResourceLocations("file:" + location);
    }
}
