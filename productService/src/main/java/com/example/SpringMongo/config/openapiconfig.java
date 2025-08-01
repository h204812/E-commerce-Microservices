package com.example.SpringMongo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class openapiconfig {

    @Bean
    public OpenAPI productserviceopenApi(){
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("This is the REST API for product service")
                        .version("V0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description(" you can refer to product service Documentation")
                        .url("https://product-service-dummy-url.com/docs"));

    }
}
