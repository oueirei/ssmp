package com.springboot_ssmp.controller.utils;

import lombok.Data;

@Data
public class Ret {
    private boolean flag;
    private Object data;
    private String mes;

    public Ret(){};
//构造函数 相当于
//Ret ret = new Ret();// 创建对象，相当于调用无参构造
//ret.setFlag(true);
    public Ret(boolean flag){
        this.flag = flag;
    }

    public Ret(boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
    public Ret(boolean flag,String mes){
        this.flag = flag;
        this.mes = mes;
    }
    public Ret(String mes){
        this.flag = false;
        this.mes = mes;
//出异常之后返回的ret有三个值：flag，data,mes;data默认null
    }
}
