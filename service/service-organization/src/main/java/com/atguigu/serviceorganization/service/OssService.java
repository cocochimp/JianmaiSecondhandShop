package com.atguigu.serviceorganization.service;

import org.springframework.web.multipart.MultipartFile;
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
