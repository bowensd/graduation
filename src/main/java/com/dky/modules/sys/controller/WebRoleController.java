package com.dky.modules.sys.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.modules.sys.model.Role;
import com.dky.modules.sys.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * describe: 角色
 *
 * @author bowen
 * @date 2018/5/23
 */
@RestController
@RequestMapping(value = Constant.role)
public class WebRoleController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RoleService roleService;

    @Mylog("删除角色")
    @DeleteMapping(value = {""})
    @ApiOperation("删除角色")
    public R deleteRole(@RequestBody JSONArray ids){
        return R.ok(roleService.delete(ids));
    }

    /**
     *describe:根据Id查找角色
     *
     *@author bowen
     *@date 2018/5/24
     */
    @Mylog("根据Id查找角色")
    @GetMapping(value = "/{id}")
    @ApiOperation("根据Id查找角色")
    public R selectById(@PathVariable String id){
        return R.ok(roleService.selectById(id));
    }

    /**
     *describe:获取角色列表
     *
     *@author bowen
     *@date 2018/5/24
     */
    @Mylog("获取角色列表")
    @PostMapping(value="/list")
    @ApiOperation("获取角色列表")
    public R select(@RequestBody JSONObject json){
        return R.ok(roleService.selectList(json));
    }

    /**
     *describe:保存或更新角色
     *
     *@author bowen
     *@date 2018/5/24
     */
    @Mylog("保存或更新角色")
    @PostMapping(value={""})
    @ApiOperation("保存或更新角色")
    public R saveOrUpdage(@RequestBody Role role){
        return R.ok(roleService.saveOrUpdate(role));
    }


    @PostMapping(value="/listNew")
    @ApiOperation("获取角色列表New --返回参数为list<map>")
    public R listNew(@RequestBody JSONObject json){
        return R.ok(roleService.listNew(json));
    }


}

