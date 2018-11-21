package com.imooc.web;

import com.imooc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hang
 */
@ControllerAdvice
@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object userNotExit(UserNotExistException ex){
        Map<String,Object> map = new HashMap<>(2);
        map.put("id",ex.getId());
        map.put("message",ex.getMessage());
        return map;
    }
}
