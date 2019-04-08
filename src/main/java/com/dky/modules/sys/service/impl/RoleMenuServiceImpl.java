package com.dky.modules.sys.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.modules.mq.enums.RoleMenuEnum;
import com.dky.modules.sys.dao.RoleMenuMapper;
import com.dky.modules.sys.model.RoleMenu;
import com.dky.modules.sys.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * describe:角色菜单
 *
 * @author bowen
 * @date 2018/5/23 17:01
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {


    /**
     * describe: 添加角色菜单
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRoleMenu(JSONObject json) {
        if (!json.containsKey(RoleMenuEnum.ROLEID.getStringVal())) {
            return false;
        }
        if (!json.containsKey(RoleMenuEnum.MENUIDS.getStringVal())) {
            return false;
        }

        JSONArray array = json.getJSONArray(RoleMenuEnum.MENUIDS.getStringVal());
        String roleId = json.getString(RoleMenuEnum.ROLEID.getStringVal());
        //删除原有信息
        this.baseMapper.delete(new EntityWrapper<RoleMenu>().eq(RoleMenuEnum.ROLE_ID.getStringVal(), roleId));
        //添加新的信息
        if (array.size() > 0 && roleId != null && !"".equals(roleId)) {
            RoleMenu roleMenu = null;
            for (int i = 0; i < array.size(); i++) {
                String menuId = array.getString(i);
                roleMenu = new RoleMenu();
                roleMenu.setMenuId(menuId);
                roleMenu.setRoleId(roleId);
                this.baseMapper.insert(roleMenu);
            }
            return true;
        }
        return false;
    }
//    /**
//     * describe: 添加权限菜单与权限按钮的关联关系
//     *
//     * @author bowen
//     * @date 2018/5/25
//     */
//    @Override
//    public boolean saveRoleMenu(JSONObject json) {
//        //{menu:{roleId:1,menuIds:[1,2,3,4]},button:{roleId:1,buttonIds:[1,2,3,4]}}
//        if (json.containsKey(RoleMenuEnum.MENU.getName())) {
//            JSONObject menuObj = json.getJSONObject(RoleMenuEnum.MENU.getStringVal());
//            this.saveRoleMenu(menuObj);
//        }
//
//        return true;
//    }

}