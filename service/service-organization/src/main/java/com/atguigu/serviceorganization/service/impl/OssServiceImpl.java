package com.atguigu.serviceorganization.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.serviceorganization.service.OssService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {
        //上传的操作
        //将文件的名字编程唯一的再上传
        int i = file.getOriginalFilename().lastIndexOf(".");//获取上传的文件的原名
        String suffix = file.getOriginalFilename().substring(i);
        //System.out.println("fileanme文件原名："+suffix);
        //借助  UUID 将文件名编程唯一的 重新定义
        String uuid = UUID.randomUUID().toString();
        //定义上传oss的文件路径
        String filename = "secondhandshop" + "/" + uuid + suffix;

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI5tHpAsCZp1EnFKNXwUk2";
        String accessKeySecret = "YhgCRUroxkTMPlZDl4GmkPu2qT3Grr";
        String bucketName = "cocochimp-markdown-img";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = filename;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        try {
            //file.getInputStream() 当前文件的输入流
            ossClient.putObject(bucketName, objectName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        String url = "https://" + bucketName + "." + endpoint + "/" + filename;

        return url;
    }
}