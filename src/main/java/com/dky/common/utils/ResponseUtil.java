package com.dky.common.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;

/**
 * describe:
 *
 * @author unbesito
 * @date 2018/05/03
 */
public class ResponseUtil {

    public static void out(HttpServletResponse response, Object json) {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Content-type", "application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print(JSON.parseObject(JSON.toJSONString(json)));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
