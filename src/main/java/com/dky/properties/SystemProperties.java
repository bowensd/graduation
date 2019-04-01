package com.dky.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
*describe: 系统运行信息
*
*@author unbesito
*@date 2018/5/3
*/
@Configuration
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
