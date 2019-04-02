package com.dky.common.security;

import com.dky.common.Code;
import com.dky.common.model.R;
import com.dky.common.utils.IgnorePathUtil;
import com.dky.common.utils.JwtTokenUtil;
import com.dky.common.utils.ResponseUtil;
import com.dky.properties.IgnorePathProperties;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * describe:token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 * @author bowen
 * @date 2018/05/07
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    private Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtTokenUtil.getHeader());
        try {
            if (token != null ) {
                if(!JwtTokenUtil.isTokenExpired(token)){
                    String username = JwtTokenUtil.getUsernameByToken(token);
                    if (username != null ) {
                        return new UsernamePasswordAuthenticationToken(username,null , new ArrayList<>());
                    }
                    return null;
                }else{
                    return null;
                }
            }
            return null;
        }catch (Exception e){
            return null;
        }

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String header = ((HttpServletRequest)servletRequest).getHeader(JwtTokenUtil.getHeader());
        if (header == null || !header.startsWith(JwtTokenUtil.getCoreId())) {
            String url = ((HttpServletRequest) servletRequest).getRequestURI();
            boolean isTrue = false;
            for(String key : IgnorePathUtil.getIgnoreKeyList()){
                if(url.indexOf(key) != -1){
                    filterChain.doFilter(servletRequest, servletResponse);
                    isTrue = true;
                    break;
                }
            }
            if(!isTrue){
                ResponseUtil.out((HttpServletResponse) servletResponse, R.error(Code.code_no_authorization,"无权访问"));
            }
            return;
        }

        Authentication authentication = getAuthentication((HttpServletRequest)servletRequest);
        if(null == authentication){
            ResponseUtil.out((HttpServletResponse) servletResponse, R.error(Code.code_no_authorization,"用户验证失效，请重新登陆系统"));
        }else{
            SecurityContextHolder.getContext().setAuthentication(authentication);
            servletRequest.setAttribute(JwtTokenUtil.getKey(),authentication.getPrincipal());
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
