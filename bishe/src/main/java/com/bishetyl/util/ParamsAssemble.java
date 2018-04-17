package com.bishetyl.util;

import java.lang.reflect.Field;

/**
 * Created by 汤玉龙 on 2018/4/17. 参数组装类
 */
public class ParamsAssemble {

    public String setParams(Object param,String table){
        Field[] fields = param.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
        }

        StringBuilder sql =new StringBuilder("select * from "+table+" where 1=1");

        return "";
    }
}
