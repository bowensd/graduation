package com.dky.common.annotation;

import java.lang.annotation.*;

/**
*describe: 系统日志注解
*
*@author unbesito
*@date 2018/5/9
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lelog {

    String value() default "";
}
