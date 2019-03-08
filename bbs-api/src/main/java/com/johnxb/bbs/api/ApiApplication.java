package com.johnxb.bbs.api;

import com.johnxb.bbs.dao.BbsDaoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.johnxb.bbs"})
@Configuration
@EnableSwagger2
@Import({BbsDaoConfiguration.class})
public class ApiApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public Docket testApi() {
        ParameterBuilder par = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        par.name("Authorization").description("用户令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .defaultValue("Bearer")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(par.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .globalOperationParameters(pars)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.johnxb.bbs.api.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BBS Api")
                .description("BBS Api文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}

