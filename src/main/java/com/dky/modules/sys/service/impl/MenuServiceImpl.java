package com.dky.modules.sys.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.modules.sys.dao.MenuMapper;
import com.dky.modules.sys.model.Menu;
import com.dky.modules.sys.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * describe: 菜单
 *
 * @author bowen
 * @date 2018/5/23 11:29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    /**
     * describe: 获取用户的菜单列表
     *
     * @author bink
     * @date 2018/5/23
     */
    @Override
    public List<Menu> menuListByUserName(String userName) {
        return this.baseMapper.menuListByUserName(userName);
    }
}