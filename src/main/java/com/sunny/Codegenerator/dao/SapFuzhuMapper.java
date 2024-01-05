package com.sunny.Codegenerator.dao;
import java.util.List;
import com.sunny.Codegenerator.entity.SapFuzhu;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;


public interface SapFuzhuMapper {
SapFuzhu getObjectById(@Param("id") BigDecimal id);
int deleteByIds(@Param("idList") List<String> idList);
    int updateByPrimaryKeySelective(SapFuzhu  sapFuzhu);
    int insert(SapFuzhu  sapFuzhu);
    List<SapFuzhu > queryList(SapFuzhu  sapFuzhu);


    int count(SapFuzhu  sapFuzhu);
}
