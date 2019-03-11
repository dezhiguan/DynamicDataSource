package com.gdz.dynamicdatasource.service;

import com.gdz.dynamicdatasource.annotation.DynamicDataSource;
import com.gdz.dynamicdatasource.mapper.ChinaMapper;
import com.gdz.dynamicdatasource.mapper.UserMapper;
import com.gdz.dynamicdatasource.mapper.WorldMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: guandezhi
 * @Date: 2019/3/3 10:45
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ChinaMapper chinaMapper;

    @Autowired
    private WorldMapper worldMapper;

    
    @DynamicDataSource(dataSource = "user")
    public String getUserName() {
        String userName = userMapper.queryUserName(1);
        log.info("username:{}", userName);
        return userName;
    }

    @DynamicDataSource(dataSource = "china")
    public String getChinaName() {
        String chinaName = chinaMapper.queryCountryName(0);
        log.info("chinaname:{}", chinaName);
        return chinaName;
    }

    @DynamicDataSource(dataSource = "world")
    public String getWorldName() {
        String worldName = worldMapper.queryWorldName(7);
        log.info("worldname:{}", worldName);
        return worldName;
    }



}
