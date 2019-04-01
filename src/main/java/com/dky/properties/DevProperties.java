package com.dky.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
*describe: 开发者配置信息
*
*@author unbesito
*@date 2018/5/3
*/
@Configuration
@ConfigurationProperties(prefix = "devinfo")
public class DevProperties {

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
