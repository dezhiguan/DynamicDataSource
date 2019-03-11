package com.gdz.dynamicdatasource.controller;

import com.gdz.dynamicdatasource.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: guandezhi
 * @Date: 2019/3/3 11:10
 */
@Slf4j
@RestController
public class IndexController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getUserName() {
        return userService.getUserName();
    }


    @RequestMapping(value = "/getWorldName", method = RequestMethod.GET)
    public String getWorldName() {
        return userService.getWorldName();
    }

    @RequestMapping(value = "/getChinaName", method = RequestMethod.GET)
    public String getChinaName() {
        return userService.getChinaName();
    }


}
