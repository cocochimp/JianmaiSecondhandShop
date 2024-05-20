package com.atguigu.canal;/**
 * Create By 87016on .
 */

import com.atguigu.canal.client.CanalClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 *@PackageName:com.atguigu.canal
 *@ClassName:CanalApplication
 *@Description:
 *@author retempal
 *@date 2021/11/67:09
 */
@SpringBootApplication
public class CanalApplication implements CommandLineRunner {//命令行跑
    @Resource
    private CanalClient canalClient;
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }
    @Override
    public void run(String... strings) throws Exception {//这个是只要程序启动这个就一直执行 一直处于监控状态
        //项目启动，执行canal客户端监听
        canalClient.run();
    }
}
