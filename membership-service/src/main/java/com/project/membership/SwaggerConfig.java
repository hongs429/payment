package com.project.membership;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi myPayOpenApi() {
        return GroupedOpenApi.builder()
                .group("membership")
                .pathsToMatch("/api/v1/memberships/**")
                .build();
    }


    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MyPay Documentation")
                        .version("1.0")
                );

    }
}
