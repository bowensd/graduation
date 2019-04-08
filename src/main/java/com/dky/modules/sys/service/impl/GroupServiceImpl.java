package com.dky.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.modules.sys.dao.GroupMapper;
import com.dky.modules.sys.model.Group;
import com.dky.modules.sys.service.GroupService;


/**
 * describe:
 *
 * @author bowen
 * @date 2019/03/28
 */
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    @Override
    public Page<Group> selectList(JSONObject json) {
        return null;
    }
}
