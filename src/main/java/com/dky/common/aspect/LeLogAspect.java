package com.dky.common.aspect;

import com.alibaba.fastjson.JSON;
import com.dky.common.annotation.Lelog;
import com.dky.common.utils.HttpContextUtils;
import com.dky.common.utils.IPUtils;
import com.dky.datasource.DataSourceNames;
import com.dky.datasource.DynamicDataSource;
import com.dky.datasource.annotation.DataSource;
import com.dky.modules.sys.model.Syslog;
import com.dky.modules.sys.service.SyslogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
*describe: 系统日志切面
*
*@author unbesito
*@date 2018/5/9
*/
@Aspect
@Component
public class LeLogAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SyslogService syslogService;

    @Pointcut("@annotation(com.dky.common.annotation.Lelog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();

        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Syslog sysLog = new Syslog();
        Lelog Lelog = method.getAnnotation(Lelog.class);
        if(Lelog != null){
            //注解上的描述
            sysLog.setOperation(Lelog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            String params = JSON.toJSONString(args[0]);
            sysLog.setParams(params);
        }catch (Exception e){

        }

        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        //用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        sysLog.setUsername(username);

        sysLog.setTime(time);
        sysLog.setCreateDate(new Date());
        //保存系统日志
        syslogService.insert(sysLog);
    }

}
