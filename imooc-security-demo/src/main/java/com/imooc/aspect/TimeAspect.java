package com.imooc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author hang
 */
@Aspect
public class TimeAspect {
    @Pointcut
    public void ponitCut(){}
}
