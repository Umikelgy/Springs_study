package com.lgy.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/15 9:20
 *@description:

 */
@Component
@ConfigurationProperties(prefix = "server")
public class Sql_msg {
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }



}
