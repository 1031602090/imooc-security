package com.imooc.validator;

import com.imooc.dto.User;
import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author hang
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
    /**
    * 可以在这里注入任何spring管理的bean
    * */
    @Autowired
    private HelloService helloService;
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("init");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(value);
        helloService.sayHello();
        return false;
    }
}
