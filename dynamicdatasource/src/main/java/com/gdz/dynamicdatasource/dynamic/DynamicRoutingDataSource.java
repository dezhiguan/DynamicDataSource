package com.gdz.dynamicdatasource.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: guandezhi
 * @Date: 2019/3/3 10:38
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源：{}", DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }
}
