package com.gdz.dynamicdatasource.annotation;

import java.lang.annotation.*;

/**
 * @Author: guandezhi
 * @Date: 2019/3/3 10:35
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DynamicDataSource {

    String dataSource() default "";
}