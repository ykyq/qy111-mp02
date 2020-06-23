package com.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//此注解使用在方法上
@Target(ElementType.METHOD)
//注解在运行的时候生效
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveOrUpdateEntityAnn {
    //实体类的类型
    Class<?> entityClass();
}
