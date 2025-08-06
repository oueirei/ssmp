package com.springboot_ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//異常処理
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //全ての異常を捕捉する
    @ExceptionHandler(Exception.class)
    public Ret doException(Exception ex){
        ex.printStackTrace();
        return new Ret("エラーになる");
    }
}
