package com.atguigu.servicebase.exceptionhandler;/**
 * Create By retempalon .
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@PackageName:com.atguigu.servicebase.exceptionhandler
 *@ClassName:GuliException
 *@Description:
 *@author retempal
 *@date 2021/9/1510:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuliException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常信息
    @Override
    public String toString() {
        return "{" +
        "message(消息GuliException)=" + msg +
        ", code(状态码)=" + code +
        '}';
    }
}
