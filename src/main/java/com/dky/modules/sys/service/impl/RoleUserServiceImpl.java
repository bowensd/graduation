package com.dky.modules.sys.service.impl;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.modules.mq.enums.RoleUserEnum;
import com.dky.modules.sys.dao.RoleUserMapper;
import com.dky.modules.sys.model.RoleUser;
import com.dky.modules.sys.model.User;
import com.dky.modules.sys.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*describe: 角色用户
*
*@author bowen
*@date 2018/5/23 17:00
*/
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    /**
    *describe: 根据roleId获取角色菜单关系
    *@author bowen
    *@date 2018/5/24
    */
    @Override
    public List<User> getRoleUserList(String roleId) {
        return this.baseMapper.getRoleUserList(roleId);
    }

    /**
    *describe: 添加角色用户关系--json {roelId:1,userIds:[1,2,3]}
    *@author bowen
    *@date 2018/5/24
    */
    @Override
    public boolean saveRoleUser(JSONObject json) {
        // json {roelId:1,userIds:[1,2,3]}
        if(!json.containsKey(RoleUserEnum.ROLE_ID.getStringVal())){
            return false;
        }
        if(!json.containsKey(RoleUserEnum.USERIDS.getStringVal())){
            return false;
        }
        String roleId = json.getString(RoleUserEnum.ROLE_ID.getStringVal());
        JSONArray array = json.getJSONArray(RoleUserEnum.USERIDS.getStringVal());
        if(array!=null && array.size()>0 && roleId!=null && !"".equals(roleId)){
            RoleUser roleUser = null;
            for (int i = 0; i < array.size(); i++) {
                String userId = array.getString(i);
                List<RoleUser> list = selectList(new EntityWrapper<RoleUser>().eq(RoleUserEnum.ROLE_ID.getStringVal(),roleId).eq(RoleUserEnum.USER_ID.getStringVal(),userId));
                //存在重复关系不进行添加
                if(list!=null && list.size()>0){
                    continue;
                }
                roleUser = new RoleUser();
                roleUser.setRoleId(roleId);
                roleUser.setUserId(userId);
                this.baseMapper.insert(roleUser);
            }
            return true;
        }
        return false;
    }

    /**
    *describe: 删除角色用户关系--json {roelId:1,userIds:[1,2,3]}
    *@author bowen
    *@date 2018/5/24
    */
    @Override
    public Map deleteRoleUser(JSONObject json) {
        Map map = new HashMap<String,String>(3);
        int successNum = 0;
        int errorNum = 0;
        if(!json.containsKey(RoleUserEnum.ROLE_ID.getStringVal())){
            map.put("msg","缺少参数roleId");
            return map;
        }
        if(!json.containsKey(RoleUserEnum.USERIDS.getStringVal())){
            map.put("msg","缺少参数userIds");
            return map;
        }
        String roleId = json.getString(RoleUserEnum.ROLE_ID.getStringVal());
        JSONArray array = json.getJSONArray(RoleUserEnum.USERIDS.getStringVal());
        if(array!=null && array.size()>0 && roleId!=null && !"".equals(roleId)){
            for (int i = 0; i < array.size(); i++) {
                String userId = array.getString(i);
                int result = this.baseMapper.delete(new EntityWrapper<RoleUser>().eq(RoleUserEnum.ROLE_ID.getName(),roleId).eq(RoleUserEnum.USER_ID.getName(),userId));
                if(result>0){
                    successNum++;
                }else{
                    errorNum++;
                }
            }
            map.put("successNum",successNum);
            map.put("errorNum",errorNum);
            map.put("msg",successNum>0?"success":"error");
            return  map;
        }
        map.put("msg","参数值为空");
        return map;
    }
}