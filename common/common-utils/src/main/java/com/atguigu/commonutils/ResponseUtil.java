package com.atguigu.commonutils;

import com.atguigu.commonutils.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {//响应工具

    public static void out(HttpServletResponse response, R r) {//它将使用JsonParser和JsonGenerator实例来实现JSON的实际读/写。
        ObjectMapper mapper = new ObjectMapper();//ObjectMapper类是Jackson库的主要类，它提供一些功能将数据集或对象转换的实现。
        //writeValue（参数，obj）：直接将传入的对象序列化为json，并且返回给客户端
        //writeValueAsString（obj）：将传入的对象序列化为json，返回给调用者
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            mapper.writeValue(response.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
