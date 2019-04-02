package com.dky.config;

import com.dky.common.utils.IgnorePathUtil;
import com.dky.common.utils.RedisUtil;
import com.dky.common.utils.JwtTokenUtil;
import com.dky.properties.IgnorePathProperties;
import com.dky.properties.JwtProperties;
import com.dky.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*describe:基础配置类
*
*@author bowen
*@date 2018/5/3
*/
@Configuration
public class BaseConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
    *describe: redisConfig
    *@author bowen
    *@date 2018/5/3
    */
    @Autowired
    private RedisProperties redisProperties;

    /**
    *describe: jwtConfig
    *@author bowen
    *@date 2018/5/3
    */
    @Autowired
    private JwtProperties jwtProperties;

    /**
    *describe: ignorePathConfig
    *@author bowen
    *@date 2018/5/10
    */
    @Autowired
    private IgnorePathProperties ignorePathProperties;

    /**
    *describe: redisConfig
    *@author bowen
    *@date 2018/5/3
    */
    @Bean
    public RedisUtil redisUtil(){
        RedisUtil redisUtil = new RedisUtil(redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getPassword(), redisProperties.getTimeout(),
                Integer.parseInt(redisProperties.getPool().get("max-active").toString()),
                Integer.parseInt(redisProperties.getPool().get("max-wait").toString()),
                Integer.parseInt(redisProperties.getPool().get("max-idle").toString()),
                Integer.parseInt(redisProperties.getPool().get("min-idle").toString()));
        return redisUtil;
    }

    /**
    *describe: jwtConfig
    *@author bowen
    *@date 2018/5/3
    */
    @Bean
    public JwtTokenUtil jwtUtil(){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(jwtProperties);
        return jwtTokenUtil;
    }

    /**
    *describe: ignorePathConfig
    *@author bowen
    *@date 2018/5/10
    */
    @Bean
    public IgnorePathUtil ignorePathUtil(){
        IgnorePathUtil ignorePathUtil = new IgnorePathUtil(ignorePathProperties);
        return ignorePathUtil;
    }
}
