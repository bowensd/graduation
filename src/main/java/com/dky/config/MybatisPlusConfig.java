package com.dky.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * describe:
 *
 * @author bowen
 * @date 2018/05/04
 */
@Configuration
public class MybatisPlusConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
