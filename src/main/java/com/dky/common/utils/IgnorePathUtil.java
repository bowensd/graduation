package com.dky.common.utils;

import com.dky.properties.IgnorePathProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * describe:
 *
 * @author bowen
 * @date 2018/05/10
 */
public class IgnorePathUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static IgnorePathProperties ignorePathProperties;

    public IgnorePathUtil(IgnorePathProperties ignorePathProperties){
        this.ignorePathProperties = ignorePathProperties;
    }

    public static List<String> getIgnorePathList(){
        return ignorePathProperties.getPathList();
    }

    public static List<String> getIgnoreKeyList(){
        return ignorePathProperties.getKeyList();
    }
}
