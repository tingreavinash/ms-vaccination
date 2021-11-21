package io.github.tingreavinash.microservice.citizenservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String TITLE = "Citizen Microservice";
    private static final String DESCRIPTION = "Swagger API documentation for Citizen microservice";
    private static final String VERSION = "1.0";
    private static final String TERMSOFSERVICEURL = "";
    private static final Contact CONTACT = new Contact("Avinash Tingre",
            "https://tingreavinash.github.io", "tingre.avinash@gmail.com");
    private static final String LICENSE = "";
    private static final String LICENSEURL = "";

    @Bean
    public Docket swaggerApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("io.github.tingreavinash"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(TITLE, DESCRIPTION, VERSION, TERMSOFSERVICEURL,
                CONTACT, LICENSE, LICENSEURL, Collections.emptyList());
    }
}
