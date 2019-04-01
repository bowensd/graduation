package com.dky.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dky.common.Code;
import com.dky.common.model.R;
import com.dky.modules.sys.model.TokenUser;
import com.dky.common.utils.JwtTokenUtil;
import com.dky.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @author unbesito
 * @date 2018/05/07
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public JWTLoginFilter(String url,AuthenticationManager authenticationManage){
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManage);
    }

    /**
    *describe: 接收并解析用户凭证
    *@author unbesito
    *@date 2018/5/7
    */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TokenUser tokenUser = new ObjectMapper().readValue(request.getInputStream(),TokenUser.class);
        Authentication authentication = null;
        try {
            authentication = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            tokenUser.getName(),
                            tokenUser.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (AuthenticationException  e) {
            unsuccessfulAuthentication(request,response,e);
        }
        return authentication;
    }

    /**
    *describe: 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    *@author unbesito
    *@date 2018/5/7
    */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JwtTokenUtil.generateToken(authResult.getName());
        //response.setHeader(JwtTokenUtil.getHeader(), token);
        Map map = new HashMap();
        map.put("access_token", token);
        ResponseUtil.out(response, R.ok(map));
    }

    /**
    *describe: 用户登录失败后，这个方法会被调用，直接返回给前台
    *@author unbesito
    *@date 2018/5/7
    */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            logger.error(e.toString());
            ResponseUtil.out(response, R.error(Code.code_error,"用户名密码错误"));
        } else  {
            logger.error(e.toString());
            ResponseUtil.out(response, R.error(Code.code_error,"登陆失败，请联系管理员"));
        }

    }
}
