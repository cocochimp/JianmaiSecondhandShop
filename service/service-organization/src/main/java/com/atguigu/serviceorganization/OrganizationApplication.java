package com.atguigu.serviceorganization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync //开启异步注解功能
@EnableScheduling //开启基于注解的定时任务
@SpringBootApplication
@MapperScan("com.atguigu.serviceorganization.mapper")
//@ComponentScan(basePackages = {"com.atguigu","com.atguigu.serviceorganization"}) //因为默认的包名就是com.atguigu
@EnableDiscoveryClient//nacos注册 可以发现客户端 //让云端发现注册的服务
@EnableFeignClients//调用端使用
@EnableSwagger2
public class OrganizationApplication {
    public static void main(String[] args){
        SpringApplication.run(OrganizationApplication.class,args);
    }
}