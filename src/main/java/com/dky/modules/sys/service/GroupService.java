package com.dky.modules.sys.service;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Group;



public interface GroupService extends IService<Group> {
    /**
     * describe:获取角色列表
     *
     * @author bowen
     * @date 2018/5/23
     */
    Page<Group> selectList(JSONObject json);
}
