package org.example.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition()
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerApiConfig() {
        var info = new Info()
                .title("CoffeMachine API")
                .description("SwaggerUI for testing coffee machine")
                .version("1.0");
        return new OpenAPI().info(info);
    }

}


