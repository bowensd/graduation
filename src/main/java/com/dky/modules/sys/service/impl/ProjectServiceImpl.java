package com.dky.modules.sys.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.utils.PageUtil;
import com.dky.common.utils.WrapperUtil;
import com.dky.modules.mq.enums.ProjectEnum;
import com.dky.modules.mq.enums.RoleEnum;
import com.dky.modules.sys.dao.ProjectMapper;
import com.dky.modules.sys.model.Project;
import com.dky.modules.sys.service.ProjectService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/07
 */

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper,Project> implements ProjectService {
    /**
     * describe:删除课题（伪删除）
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    public Map delete(JSONArray ids) {
        int successNum = 0;
        int errNum = 0;
        String msg = "error";
        for (int i = 0; i < ids.size(); i++) {
            Integer id = ids.getInteger(i);
            List<Project> list = this.selectList(new EntityWrapper().eq(ProjectEnum.STATE_CODE.getStringVal(), id));
            if (list != null && list.size() > 0) {
                errNum++;
                continue;
            }
            Project project = new Project();
            project.setId(id);
            project.setDeletedCode(RoleEnum.DELETED.getIntegerVal());
            project.setDeletedName(RoleEnum.DELETED.getName());
            boolean flag = this.updateById(project);

            if (flag) {
                successNum++;
                msg = "success";
            } else {
                errNum++;
            }
        }
        Map map = new HashMap<String, String>(3);
        map.put("succNum", successNum);
        map.put("errNum", errNum);
        map.put("msg", msg);

        return map;
    }

    /**
     * describe: 获取全部课题列表
     *
     * @author bowen
     * @date 2019/4/27
     */
    @Override
    public Page<Project> selectList(JSONObject json) {
        //设置分页参数
        Page<Project> page = new Page<>();
        PageUtil.StartPage(page, json);

        //设置查询条件
        Project project = JSONObject.parseObject(json.toString(), Project.class);
        EntityWrapper<Project> ew = new EntityWrapper<Project>();

        //未删除
        ew.eq(ProjectEnum.DELETED_CODE.getStringVal(), ProjectEnum.UNDELETED.getStringVal());

        //状态码，已选/未选
        WrapperUtil.eq(ew,json,ProjectEnum.STATE_CODE.getStringVal(),ProjectEnum.STATE_CODE.getStringVal());
        //教师ID
        WrapperUtil.eq(ew, json, ProjectEnum.TEACHER_ID.getStringVal(),  ProjectEnum.TEACHER_ID.getStringVal());

        //学生ID
        WrapperUtil.eq(ew, json, ProjectEnum.STUDENT_ID.getStringVal(),  ProjectEnum.STUDENT_ID.getStringVal());

        List<Project> list = baseMapper.selectPage(page, ew);

        //进行查询并翻页
        return page.setRecords(list);
    }



    /**
     *describe: 添加或修改课题
     *@author bowen
     *@date 2019/4/27
     */
    @Override
    public boolean saveOrUpdate(Project project) {
        if(project==null){
            return false;
        }
        if(project.getDeletedCode()!=null){
            project.setDeletedName(project.getDeletedCode().equals(ProjectEnum.DELETED.getIntegerVal())?ProjectEnum.DELETED.getName():ProjectEnum.UNDELETED.getName());
        }
        return this.insertOrUpdate(project);
    }
}
