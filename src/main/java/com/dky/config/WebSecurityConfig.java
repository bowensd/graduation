package com.dky.config;

import com.dky.common.security.JWTAuthenticationFilter;
import com.dky.common.security.JWTLoginFilter;
import com.dky.common.security.CustomAuthenticationProvider;
import com.dky.common.utils.IgnorePathUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * describe:SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @author bowen
 * @date 2018/05/07
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    public WebSecurityConfig(@Qualifier("tokenUserServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();

        //除配置文件忽略路径其它所有请求都需经过认证和授权
        for(String path: IgnorePathUtil.getIgnorePathList()){
            registry.antMatchers(path).permitAll();
        }
        //关闭跨站请求防护
        registry.and().cors();
        registry.and().csrf().disable();
        //前后端分离采用JWT 不需要session
        registry.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        registry.and()
                .authorizeRequests()
                // 所有 /web/login 的POST请求 都放行
                .antMatchers(HttpMethod.POST, "/web/login").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated();

        registry.and()
                //添加JWT过滤器 除/web/login其它请求都需经过此过滤器
                .addFilterBefore(new JWTLoginFilter("/web/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService));
    }
}
