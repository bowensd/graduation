package com.dky.modules.sys.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Menu;


import java.util.List;
import java.util.Map;


/**
*describe: 菜单
*
*@author bowen
*@date 2018/5/23 11:30
*/
public interface MenuService extends IService<Menu> {
    /**
     *describe: 获取用户的菜单列表
     *@author bink
     *@date 2018/5/23
     */
    List<Menu> menuListByUserName(String userName);
}
