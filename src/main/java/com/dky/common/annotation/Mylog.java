package com.dky.common.annotation;

import java.lang.annotation.*;

/**
*describe: 系统日志注解
*
*@author bowen
*@date 2018/5/9
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mylog {

    String value() default "";
}
