package com.dky.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.dky.modules.mq.enums.PageEnum;

/**
 * describe: 分页工具类
 *
 * @author bink
 * @date 2018/05/16
 */
public class PageUtil<T> {
     /**
     *describe: 开启分页
     *@author bink
     *@date 2018/5/17
     *
     * @param page 分页对象
     * @param json 包含分页参数的json格式字符串
     * @param <T>
     */
    public static<T> void StartPage(Page<T> page, String json){
        if(json==null || "".equals(json)){
            return;
        }
        try {
            JSONObject obj = JSONObject.parseObject(json);
            if(obj!=null){
                StartPage(page,obj);
            }
        }catch (Exception e){
            return ;
        }

    }

     /**
     *describe: 开启分页
     *@author bink
     *@date 2018/5/16
     *
     * @param page 分页对象
     * @param json 包含分页参数的json对象
     * @param <T> 要查询的对象类型
     */
    public static<T> void StartPage(Page<T> page, JSONObject json){
        if(json==null){
            return;
        }
        Integer PageSize = PageEnum.PAGEDMAXSIZE.getIntegerVal();
        Integer PageNum=PageEnum.PAGENUM.getIntegerVal();
        if(json.containsKey(PageEnum.PAGESIZE.getStringVal())){
            PageSize = json.getInteger(PageEnum.PAGESIZE.getStringVal());
        }
        if(json.containsKey(PageEnum.PAGENUM.getStringVal())){
            PageNum = json.getInteger(PageEnum.PAGENUM.getStringVal());
        }
        StartPage(page,PageSize,PageNum);
    }

     /**
     *describe:开启分页
     *@author bink
     *@date 2018/5/16
     * @param page 分页对象
     * @param pageSize 每页的大小
     * @param pageNum 当前页数
     * @param <T>
     */
    public static<T> void StartPage(Page<T> page, Integer pageSize,Integer pageNum){
        if(page==null){
            return ;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);
    }
}
