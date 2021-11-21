package io.github.tingreavinash.microservice.vaccinationcenterservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI()
                .info(getApiInfo())
                .externalDocs(new ExternalDocumentation()
                        .description("Github Link")
                        .url("https://github.com/tingreavinash/ms-vaccination/tree/master/vaccination-center-service"));
    }

    private Info getApiInfo() {
        return new Info()
                .title("Vaccination Center Microservice")
                .description("Swagger API documentation for Citizen microservice")
                .contact(new Contact()
                        .name("Avinash Tingre")
                        .url("https://tingreavinash.github.io")
                        .email("tingre.avinash@gmail.com"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .version("1.0");
    }
}
