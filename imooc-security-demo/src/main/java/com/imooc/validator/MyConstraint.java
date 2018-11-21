package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target 表明该注解可以标注在那种元素上，例如属性、方法、类、包、etc...
@Target({ElementType.FIELD,ElementType.METHOD})
//@Retention 定义被它所注解的注解保留多久，
// 有三种取值
//    SOURCE  被编译器忽略
//    CLASS 注解将会被保留在Class文件中，但在运行时并不会被VM保留。这是默认行为，
//          所有没有用Retention注解的注解，都会采用这种策略。
//    RUNTIME 保留至运行时。所以我们可以通过反射去获取注解信息。
@Retention(RetentionPolicy.RUNTIME)
//说明当前的注解需要使用哪个类来校验
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    /*
    * message、groups、payload字段均为必须项，
    * */
    String message() ;//校验未通过时返回的信息
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}