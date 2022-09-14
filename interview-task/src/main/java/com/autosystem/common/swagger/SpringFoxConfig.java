package com.autosystem.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .paths(Predicate.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Autosystem application for interview-task purpose")
                .description("If you are dealer you can use these endpoints: \n" +
                        "- Vehicle Part Dealer Controller - for fetch list of all available car parts for specify mark and model\n" +
                        "- Warehouse Stock Controller - for get info about selected part availability in warehouse and order realization time\n" +
                        "- Workshop Service Dealer Controller - for get info about services available for specific mark and model in given date period")
                .version("1.0.0")
                .build();
    }
}
