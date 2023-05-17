package com.liuzhuo.common.handler;

import com.liuzhuo.common.exception.ApiException;
import com.liuzhuo.common.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResultVo exceptionHandler(Exception e){

        return ResultVo.error(500,e.getMessage());
    }
}
