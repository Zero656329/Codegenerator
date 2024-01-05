package com.sunny.Codegenerator.entity;

import lombok.Data;

@Data
public class Table {
    //字段值
    private String cname;
   //表名
    private String ctable;
    //类名
    private String entityname;
    //表中文名
    private String ctablename;

    //字段类型
    private String ctype;
   //注释
    private String cmemo;
    //保存路径
    private String saveUrl;
    //包路径
    private String basePackageUrl;
}
