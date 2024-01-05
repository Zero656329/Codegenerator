package com.sunny.Codegenerator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.util.Locale;
import java.util.Map;

@Component
public class FreemarkerUtil {
    @Autowired
    Configuration freeMarker;

    /**
     * 判断包路径是否存在
     */
    private void pathJudgeExist(String path){
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
    }
    /**
     * 生成代码
     */
    public void generate(Map<String, Object> root, String templateName, String saveUrl, String entityName) throws Exception {
        //获取模板
        Template template = freeMarker.getTemplate(templateName);
        //输出文件
        printFile(root, template, saveUrl, entityName);
    }

    public byte[] generatestream(Map<String, Object> root, String templateName) throws Exception {
        //获取模板
        Template template = freeMarker.getTemplate(templateName);

        StringWriter out = new StringWriter();


        template.process(root,  out);

        String o=out.toString();
        byte[] b=o.getBytes();
        out.close();
        return b;
    }
    /**
     * 输出到文件
     */
    public  void printFile(Map<String, Object> root, Template template, String filePath, String fileName) throws Exception  {
        pathJudgeExist(filePath);
        File file = new File(filePath, fileName );
        if(!file.exists()) {
            file.createNewFile();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));





        template.process(root,  out);
        out.close();
    }


    /**
     * 将[数据库类型]转换成[Java类型],如果遇到没有写的类型,会出现Undefine,在后面补充即可
     */
    public  String convertToJava(String columnType){
        String result;
        switch (columnType){
            case "VARCHAR2":{
                result = "String";
                break;
            }
            case "NUMBER":{
                result = "BigDecimal";
                break;
            }

            case "DATE":{
                result = "Date";
                break;
            }
            case "DECIMAL":{
                result = "BigDecimal";
                break;
            }
            default:{
                result = "String";
                break;
            }
        }
        return result;
    }
    /**
     * 下划线命名转为驼峰命名
     */
    public String underlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1));
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
    /**
     * 获取类名
     */
    public String getEntityName(String tableName){
        return underlineToHump(capFirst(tableName.toLowerCase()));
    }

    /**
     * 获取首字母小写类名
     */
    public String getEntityNameLower(String tableName){
        return capFirst(tableName.toLowerCase());
    }
    /**
     * 首字母大写
     */
    public  String capFirst(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
    }

    /**
     * 首字母大写
     */
    public  String smallfirst(String str){
        return str.substring(0,1).toLowerCase()+str.substring(1);
    }
}
