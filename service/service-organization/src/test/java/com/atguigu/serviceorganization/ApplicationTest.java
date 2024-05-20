package com.atguigu.serviceorganization;

import com.atguigu.serviceorganization.util.ChineseCharToEnUtil;
import com.atguigu.serviceorganization.util.SnowflakeIdWorker;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @org.junit.Test
    public void test01(){
        ChineseCharToEnUtil c = new ChineseCharToEnUtil();
        System.out.println(c.getPingYin("小明"));
    }

    @org.junit.Test
    public void test02(){
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i=0;i<100;i++){
            long id = idWorker.nextId()+i;
            System.out.println(id);
        }

    }

}
