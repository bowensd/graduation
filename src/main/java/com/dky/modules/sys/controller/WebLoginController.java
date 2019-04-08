package com.dky.modules.sys.controller;

import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.modules.sys.model.TokenUser;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * describe:
 *
 * @author bowen
 * @date 2018/05/03
 */
@RestController
@RequestMapping(Constant.login)
public class WebLoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
    *describe: 用户登陆入口映射
    *@author bowen
    *@date 2018/5/14 20:08
    */
    @ApiOperation(value = "获取用户列表")
    @PostMapping(value = {""})
    @Mylog("登录")
    public R login(HttpServletRequest request, @RequestBody TokenUser tokenUser){
        logger.info(tokenUser.toString());
        return R.ok("登陆成功!");
    }

    /**
    *describe: 用户验证映射
    *@author bowen
    *@date 2018/5/14 20:08
    */
    @ApiOperation(value = "获取用户列表")
    @PostMapping(value = {"check"})
    @Mylog("用户登录token验证")
    public R check(){
        return R.ok("验证成功!");
    }
}
