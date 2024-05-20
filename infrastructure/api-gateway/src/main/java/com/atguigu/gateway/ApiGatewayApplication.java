package com.atguigu.gateway;/**
 * Create By 87016on .
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@PackageName:com.atguigu.gateway
 *@ClassName:ApiGatewayApplication
 *@Description:
 *@author retempal
 *@date 2021/11/68:16
 */
@SpringBootApplication
@EnableDiscoveryClient//服务发现
public class ApiGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(ApiGatewayApplication.class,args);
    }
}
