package com.wenyu7980.basic.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置
 * @author wenyu
 * @date 2020-01-28 
 */
@Configuration
@EnableSwagger2
public class SwaggerMvnConfig implements WebMvcConfigurer {
    @Bean
    public Docket loginDocument() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("用户登录")
                .select().apis(RequestHandlerSelectors
                        .basePackage("com.wenyu7980.basic.authorization"))
                .build().pathMapping("/")
                .apiInfo(new ApiInfoBuilder().description("用户登录").build());
    }

    @Bean
    public Docket organizationDocument() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("组织机构")
                .select().apis(RequestHandlerSelectors.basePackage(
                        "com.wenyu7980.basic.service.organization")).build()
                .globalOperationParameters(setHeaderToken()).pathMapping("/")
                .apiInfo(new ApiInfoBuilder().description("组织机构").build());
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
