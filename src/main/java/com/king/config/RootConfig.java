package com.king.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jin82 on 2016/06/10.
 */
@Configuration
@ComponentScan(
        basePackages = {"com.king"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
        }
)
public class RootConfig {

}
