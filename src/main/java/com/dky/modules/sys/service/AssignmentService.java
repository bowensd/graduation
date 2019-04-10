package com.dky.modules.sys.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Assignment;

public interface AssignmentService extends IService<Assignment> {

    Page<Assignment> selectById(JSONObject json);
}
