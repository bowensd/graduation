package com.dky.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.RoleMenu;


/**
*describe:角色菜单
*
*@author bowen
*@date 2018/5/23 16:57
*/
public interface RoleMenuService extends IService<RoleMenu> {

    /**
    *describe: 添加角色菜单
    *@author bowen
    *@date 2018/5/23  
    */
    boolean saveRoleMenu(JSONObject json);

   // public boolean saveRoleMenu(JSONObject json);
}
