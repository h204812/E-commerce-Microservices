package com.example.Inventory.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class openAPIconfig {

    @Bean
    public OpenAPI inventoryServiceOpenAPI(){
        return new OpenAPI().info(new Info().title("InventoryService OpenAPI")
                .description("This is openAPI documentation of inventory service")
                .version("v0.0.1").license(new License().name("Apache 2.0"))
                ).externalDocs(
                        new ExternalDocumentation().description("You can refer " +
                                "to the documentation of ineventory service here")
                                .url("http://localhost:8082/swagger-ui/html")
        );
    }
}
