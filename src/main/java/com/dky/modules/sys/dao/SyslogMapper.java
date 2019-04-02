package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dky.modules.sys.model.Syslog;
import org.apache.ibatis.annotations.Mapper;

/**
*describe: 系统日志
*
*@author bowen
*@date 2018/5/9
*/
@Mapper
public interface SyslogMapper extends BaseMapper<Syslog> {
}
