package com.sunny.Codegenerator.dao;
import java.util.List;

import com.sunny.Codegenerator.entity.AuthDict;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;


public interface AuthDictMapper {
AuthDict getObjectById(@Param("id") BigDecimal id);
int deleteByIds(@Param("idList") List<String> idList);
    int updateByPrimaryKeySelective(AuthDict  authDict);
    int insert(AuthDict  authDict);
    List<AuthDict > queryList(AuthDict  authDict);
    int count(AuthDict  authDict);
    int insertBatch(@Param("list") List<AuthDict> list);
}
