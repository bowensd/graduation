package com.dky.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.enums.DicEnum;
import com.dky.modules.sys.dao.TokenUserMapper;
import com.dky.modules.sys.model.TokenUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

/**
*describe: 用户验证
*
*@author bowen
*@date 2018/5/7
*/
@Service
public class TokenUserServiceImpl extends ServiceImpl<TokenUserMapper, TokenUser> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        TokenUser tokenUser = new TokenUser();
        tokenUser.setName(name);
       // tokenUser.setStateCode(DicEnum.ENABLE.getIntegerVal());
        EntityWrapper<TokenUser> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(tokenUser);
        List<TokenUser> tokenUserList = baseMapper.selectList(entityWrapper);
        if(null != tokenUserList && tokenUserList.size() > 0){
            return new org.springframework.security.core.userdetails.User(tokenUserList.get(0).getName(), tokenUserList.get(0).getPassword(), emptyList());
        }
        return null;
    }
}
