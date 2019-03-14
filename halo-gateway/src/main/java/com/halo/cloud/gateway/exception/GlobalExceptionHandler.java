package com.halo.cloud.gateway.exception;

import com.halo.cloud.gateway.web.BaseController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.Map;

/**
 * @author MelloChan
 * @date 2018/5/26
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Map<String,Object>handle(){
        return rtnParam(40017,null);
    }
}
