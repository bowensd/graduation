package com.dky.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
*describe: Wrapper查询工具类
*
*@author bowen
*@date 2018/5/24 15:16
*/
public class WrapperUtil {

     /**
     *describe: 设置查询条件--相等
     * @author bowen
     * @date 2018/5/24
     *
     * @param wrapper 查询对象
     * @param json 含有查询条件与值的json数组
     * @param key json中的key
     * @param dbField 数据库与之对应的字段
     */
    public static Wrapper eq(Wrapper wrapper, JSONObject json, String key, String dbField){
        if(json==null){
            return wrapper;
        }
        if(key==null){
            return wrapper;
        }
        if(!json.containsKey(key)){
            return wrapper;
        }
        Object value = json.get(key);
        return eq(wrapper,value,dbField);
    }
     /**
     *describe:设置查询条件--相等
     * @author bowen
     * @date 2018/5/24
     *
     * @param wrapper 查询对象
     * @param value 要比较的值
     * @param dbField 数据库字段
     */
    public static Wrapper eq(Wrapper wrapper,Object value, String dbField){
        if(wrapper==null){
            return wrapper;
        }
        if(dbField==null || "".equals(dbField)){
            return wrapper;
        }
        if(value==null || "".equals(value)){
            return wrapper;
        }
        return wrapper.eq(dbField,value);
    }
}
