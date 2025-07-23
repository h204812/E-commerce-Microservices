package com.example.orderService.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIconfig {

    @Bean
    public OpenAPI orderserviceOpenAPI(){
        return new OpenAPI().info(new Info().title("orderServiceOpenAPI").description("This is the documentation of order" +
                "ServiceRestAPI").license(new License().name("Apache 2.0")
                ).version("v0.0.1"))
                .externalDocs(new ExternalDocumentation().description("You can refer to orderService documentation here ")
                        .url("https://localhostDummy:8151"));
    }
}
