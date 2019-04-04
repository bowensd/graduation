package com.dky.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.dky.common.model.R;
import com.dky.modules.sys.service.RoleUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
*describe: 角色用户
*@author bowen
*@date 2018/5/23  
*/
@RestController
@RequestMapping(value = Constant.roleuser)
public class    WebRoleUserController {
    @Resource
    private RoleUserService roleUserService;

    /**
    *describe: 根据角色获取用户
    *@author bowen
    *@date 2018/5/23  
    */
    @ApiOperation("根据角色获取用户列表")
    @GetMapping("/{roleId}")
    public R getRoleUserList(@PathVariable String roleId){
        return R.ok(roleUserService.getRoleUserList(roleId));
    }

    /**
    *describe: 添加角色用户关系--一个角色添加多个用户
    *@author bowen
    *@date 2018/5/23  
    */
    @ApiOperation("添加角色用户关系--json {roleId:1,userIds:[1,2,3]}")
    @PostMapping({""})
    public R saveRoleUser(@RequestBody JSONObject json){
        return R.ok(roleUserService.saveRoleUser(json));
    }

    /**
    *describe: 删除角色用户关系--一个角色删除多个用户
    *@author bowen
    *@date 2018/5/23  
    */
    @ApiOperation("删除角色用户关系--json {roleId:1,userIds:[1,2,3]}")
    @DeleteMapping({""})
    public R deleteRoleUser(@RequestBody JSONObject json){
        return R.ok(roleUserService.deleteRoleUser(json));
    }


}

