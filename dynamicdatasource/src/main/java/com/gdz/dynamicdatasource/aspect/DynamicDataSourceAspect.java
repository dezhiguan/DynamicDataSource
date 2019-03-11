package com.gdz.dynamicdatasource.aspect;

import com.gdz.dynamicdatasource.annotation.DynamicDataSource;
import com.gdz.dynamicdatasource.dynamic.DataSourceKey;
import com.gdz.dynamicdatasource.dynamic.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: guandezhi
 * @Date: 2019/3/3 10:22
 */
@Slf4j
@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {


    @Around("@annotation(com.gdz.dynamicdatasource.annotation.DynamicDataSource)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return doinvoke(pjp);
    }

    private Object doinvoke(ProceedingJoinPoint pjp) throws Throwable {
        //设置数据源
        setDynamicDataSource(pjp);
        //执行目标方法
        Object result = pjp.proceed();
        //清空数据源
        DynamicDataSourceContextHolder.clear();
        return result;
    }

    private void setDynamicDataSource(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        DynamicDataSource dynamicDataSource = targetMethod.getAnnotation(DynamicDataSource.class);
        if (dynamicDataSource != null) {
            String dataSource = dynamicDataSource.dataSource();
            if (StringUtils.isNotEmpty(dataSource)) {
                if ("china".equals(dataSource)) {
                    DynamicDataSourceContextHolder.set(DataSourceKey.DB_CHINA);
                } else if ("world".equals(dataSource)) {
                    DynamicDataSourceContextHolder.set(DataSourceKey.DB_WORLD);
                }
            }
        }
        log.info("当前aop数据源：{}", DynamicDataSourceContextHolder.get());
    }
}
