package com.dky.datasource.annotation;

import java.lang.annotation.*;

/**
*describe: 多数据源注解
*
*@author unbesito
*@date 2018/5/4
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
