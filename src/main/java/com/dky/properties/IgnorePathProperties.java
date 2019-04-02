package com.dky.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author bowen
 * @date 2018/05/09
 */
@Configuration
@ConfigurationProperties(prefix = "ignored")
public class IgnorePathProperties {

    private List<String> pathList = new ArrayList<>();

    private List<String> keyList = new ArrayList<>();

    public List<String> getPathList() {
        return pathList;
    }

    public void setPathList(List<String> pathList) {
        this.pathList = pathList;
    }

    public List<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }
}
