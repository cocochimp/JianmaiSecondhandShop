package com.atguigu.servicebase.exceptionhandler; /**
 * Create By retempalon .
 */


import com.atguigu.commonutils.ExceptionUtil;
import com.atguigu.commonutils.R;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.EOFException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *@PackageName:com.atguigu.servicebase.exceptionhandler
 *@ClassName:GlobalExceptionHandler
 *@Description:
 *@author retempal
 *@date 2021/9/157:28
 */
@ControllerAdvice
@Slf4j//外部存放日志
public class GlobalExceptionHandler {//全局异常处理
    //指定出现什么异常执行这个方法 //优先级3
    @ExceptionHandler(Exception.class)
    @ResponseBody//json形式返回数据
    public R error(Exception e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了全局异常处理。。。");
    }
    //优先级2
    //特定的异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//未了能够返回数据
    public R error(ArithmeticException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了ArithmeticException算数异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody//未了能够返回数据
    public R error(NullPointerException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了NullPointerException空指针异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody//未了能够返回数据
    public R error(ArrayIndexOutOfBoundsException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了ArrayIndexOutOfBoundsException数组大小小于或者大于实际的数组大小异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody//未了能够返回数据
    public R error(IndexOutOfBoundsException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了IndexOutOfBoundsException数组越界异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(ClassNotFoundException.class)
    @ResponseBody//未了能够返回数据
    public R error(ClassNotFoundException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了ClassNotFoundException相关类没找到异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(EOFException.class)
    @ResponseBody//未了能够返回数据
    public R error(EOFException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了EOFException文件结束异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(InterruptedException.class)
    @ResponseBody//未了能够返回数据
    public R error(InterruptedException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了InterruptedException线程中断异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody//未了能够返回数据
    public R error(ClassCastException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了ClassCastException类型转换异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(SQLException.class)
    @ResponseBody//未了能够返回数据
    public R error(SQLException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了SQLException操作数据库异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(IOException.class)
    @ResponseBody//未了能够返回数据
    public R error(IOException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了IOExceptionI/O异常处理。。。");
    }
    //特定的异常处理
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody//未了能够返回数据
    public R error(NumberFormatException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().message("执行了NumberFormatException数字格式转化异常处理。。。");
    }
    //优先级1
    //自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody//未了能够返回数据
    public R error(GuliException e){
//        log.error(e.getMessage());//不过这个信息根本输出不了没有输出的工具 所以要详细需要类
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();//打印异常轨迹
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
