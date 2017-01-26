package com.erickrim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by krime on 1/25/17.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.quote/application-prod.properties")
public class ProdConfig {
}
