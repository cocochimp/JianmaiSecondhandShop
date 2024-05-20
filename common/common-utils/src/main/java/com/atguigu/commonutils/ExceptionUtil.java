package com.atguigu.commonutils;/**
 * Create By retempalon .
 */

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author retempal
 * @PackageName:com.atguigu.commonutils
 * @ClassName:ExceptionUtil
 * @Description:
 * @date 2021/9/1516:13
 */
public class ExceptionUtil {
    public static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();//创建字符串写入流
            pw = new PrintWriter(sw);//创建打印流 把字符串流放入打印流
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);//打印异常轨迹通过打印流
            pw.flush();//然后字符串流刷新该流的缓冲
            sw.flush();//然后打印流刷新该流的缓冲
            System.out.println(sw.toString());
            return sw.toString();
        } finally {
            if (pw != null) {
            try {
                pw.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }

            if (sw != null) {
            try {
                sw.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


        }

    }
}
