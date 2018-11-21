package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author hang
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("FUCK!");
    }
}
