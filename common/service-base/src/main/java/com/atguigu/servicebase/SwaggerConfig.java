package com.atguigu.servicebase;/**
 * Create By retempalon .
 */

import com.google.common.base.Predicates;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *@PackageName:com.atguigu.servicebase
 *@ClassName:SwaggerConfig
 *@Description:
 *@author retempal
 *@date 2021/9/1217:03
 */
@Configuration//配置类
@EnableSwagger2//swagger注解
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(){
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        //这里.paths(Predicates.not(PathSelectors.regex("/admin/.*")))不注释就会导致admin的路径swagger识别不到
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
//                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .globalOperationParameters(pars);//注意这里//如果路径有error就不显示//如果是路径有admin就不显示
    }
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站-二手商城API文档")
                .description("本文档描述了二手商城微服务接口定义")
                .version("1.0")
                .contact(new Contact("java", "http://atguigu.com", "870561609@qq.com"))
                .build();

    }

}
