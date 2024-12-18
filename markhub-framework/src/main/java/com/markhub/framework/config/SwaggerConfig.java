package com.markhub.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: emp
 * @Date: 2024/12/18 14:30
 * @Description: swagger
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.markhub"};
        return GroupedOpenApi.builder().group("markhub")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("ceekayshen@foxmail.com");

        return new OpenAPI().info(new Info()
                .title("markhub")
                .description("markhub")
                .contact(contact)
                .version("1.0")
                .termsOfService("https://markhub.com")
                .license(new License().name("MIT")
                        .url("https://markhub.com")));
    }

}