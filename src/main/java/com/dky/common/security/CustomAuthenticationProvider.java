package com.dky.common.security;


import com.dky.common.utils.MD5Util;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * describe:
 *
 * @author bowen
 * @date 2018/05/07
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if(null != userDetails){
            //if(userDetails.getPassword().equals(MD5Util.md5(password))){  这里应该是因为写入用户的时候用户密码使用了MD5加密，所以在数据库中是看不到明文密码的。
            //而userDetails.getPassword()是数据库中的md5码
            if(MD5Util.md5(userDetails.getPassword()).equals(MD5Util.md5(password))){
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                Authentication auth = new UsernamePasswordAuthenticationToken(name, MD5Util.md5(password), authorities);
                return auth;
            }else{
                throw new BadCredentialsException("密码错误");
            }
        }else{
            throw new UsernameNotFoundException("用户不存在或用户账号被禁用");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
