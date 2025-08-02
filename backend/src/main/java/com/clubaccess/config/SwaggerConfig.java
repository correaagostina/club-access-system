package com.clubaccess.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI clubAccessOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Club Access System API")
                        .description("API para control de accesos mediante QR en un club")
                        .version("1.0.0"));
    }
}