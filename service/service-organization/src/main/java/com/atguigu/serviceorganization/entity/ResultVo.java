package com.atguigu.serviceorganization.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResultVo<T> {
    private String mess;
    private boolean isOk;
    private T data;

    public ResultVo(){}

    public ResultVo(String mess, boolean isOk, T data) {
        this.mess = mess;
        this.isOk = isOk;
        this.data = data;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
