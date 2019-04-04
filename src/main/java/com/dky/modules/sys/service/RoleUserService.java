package com.dky.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.RoleUser;
import com.dky.modules.sys.model.User;

import java.util.List;
import java.util.Map;

/**
*describe:角色用户
*
*@author bowen
*@date 2018/5/23 16:57
*/
public interface RoleUserService extends IService<RoleUser> {

    /**
    *describe: 根据roleId获取角色菜单关系
    *@author bowen
    *@date 2018/5/24  
    */
    List<User> getRoleUserList(String roleId);

    /**
    *describe: 添加角色用户关系--json {roelId:1,userIds:[1,2,3]}
    *@author bowen
    *@date 2018/5/24
    */
    boolean saveRoleUser(JSONObject json);

    /**
    *describe: 删除角色用户关系--json {roelId:1,userIds:[1,2,3]}
    *@author bowen
    *@date 2018/5/24
    */
    Map deleteRoleUser(JSONObject json);
}
