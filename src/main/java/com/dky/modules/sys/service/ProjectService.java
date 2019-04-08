package com.dky.modules.sys.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Project;
import java.util.Map;

/**
 * describe:课题
 *
 * @author bowen
 * @date 2019/4/27 16:57
 */
public interface ProjectService extends IService<Project> {
    Map delete(JSONArray ids);

    Page<Project> selectList(JSONObject json);

    boolean saveOrUpdate(Project project);


}
