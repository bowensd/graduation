package com.dky.modules.sys.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Role;

import java.util.Map;

/**
 * describe:角色
 *
 * @author bowen
 * @date 2018/5/23 16:57
 */
public interface RoleService extends IService<Role> {
    /**
     * describe:删除角色（伪删除）
     *
     * @author bowen
     * @date 2018/5/23
     */
    Map delete(JSONArray ids);

    /**
     * describe:保存或更新
     *
     * @author bowen
     * @date 2018/5/23
     */
    boolean saveOrUpdate(Role role);

    /**
     * describe:获取角色列表
     *
     * @author bowen
     * @date 2018/5/23
     */
    Page<Role> selectList(JSONObject json);

    /**
    *describe:获取角色列表，并附带角色下人数
    *@author bowen
    *@date 2018/5/24  
    */
    Page<Map<String,Object>> listNew(JSONObject json);
}
