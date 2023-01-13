package com.example.dreamforest.config

import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

class SwaggerConfig {
    @Bean
    fun api() : Docket{
        return Docket(DocumentationType.OAS_30)
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.dreamforest.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
    }

    fun apiInfo() : ApiInfo {
        return ApiInfoBuilder()
            .title("Dreamforest 프로토타입")
            .description("Dreamforest 프로토타입")
            .version("1.0.0")
            .build()
    }
}