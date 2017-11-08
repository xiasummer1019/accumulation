package com.tool.cfg.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@PropertySource(value = "classpath:config/api/swagger.properties")
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.framework.controller")
public class SwaggerConfig {

    @Bean
    public Docket getApiInfo() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(outApiInfo());
    }
    private ApiInfo outApiInfo() {
        return new ApiInfo(
                "api开放列表", // title 标题
                "外部接口文档 REST风格", // description 描述 标题下
                "1.0.0", // version
                "www.baidu.com", // termsOfService
                new Contact("xm","","xiasummer1019@hotmail.com"), // contact
                "Apache 2.0", // licence
                "http://www.apache.org/licenses/LICENSE-2.0.html" // licence url
        );
    }
}