package com.dky.modules.sys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.modules.sys.model.Project;
import com.dky.modules.sys.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/07
 */
@RestController
@RequestMapping(value = Constant.project)
public class WebProjectController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    ProjectService projectService;

    @Mylog("获取课题列表")
    @PostMapping(value = "/list")
    @ApiOperation("获取课题列表,json中加入条件可按条件查询")//"student_id":1,"teacher_id":2
    public R list(@RequestBody JSONObject json) {
        return R.ok(projectService.selectList(json));
    }


    /**
     * describe:保存或更新课题
     *
     * @author bowen
     * @date 2018/5/24
     */
    @Mylog("保存或更新课题")
    @PostMapping(value = {""})
    @ApiOperation("保存或更新课题")
    public R saveOrUpdage(@RequestBody Project project) {
        return R.ok(projectService.saveOrUpdate(project));
    }

    @Mylog("删除课题，未删除")
    @DeleteMapping(value = {""})
    @ApiOperation("删除课题")
    public R deleteProject(@RequestBody JSONArray ids){
        return R.ok(projectService.delete(ids));
    }

    /**根据课题Id查找课题
     *describe:
     *@author bowen
     *@date 2019/4/7
     */
    @Mylog("根据课题id查找课题")
    @GetMapping(value = "/{id}")
    @ApiOperation("根据课题Id查找课题")
    public R selectById(@PathVariable String id){
        return R.ok(projectService.selectById(id));
    }


}
