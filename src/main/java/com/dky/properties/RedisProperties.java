package com.dky.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
*describe: redis配置信息
*
*@author unbesito
*@date 2018/5/3
*/
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private int database;

    private String host;

    private int port;

    private String password;

    private int timeout;

    private Map<String, String> pool = new HashMap<>(); //接收pool里面的属性值

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Map<String, String> getPool() {
        return pool;
    }

    public void setPool(Map<String, String> pool) {
        this.pool = pool;
    }
}
