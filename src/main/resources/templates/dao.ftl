package ${basePackageUrl}.mapper;
import java.util.List;
import ${basePackageUrl}.entity.${entityName};
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;


public interface ${entityName}Mapper {
${entityName} getObjectById(@Param("id") BigDecimal id);
int deleteByIds(@Param("idList") List<String> idList);
    int updateByPrimaryKeySelective(${entityName}  ${entityNameLower});
    int insert(${entityName}  ${entityNameLower});
    List<${entityName} > queryList(${entityName}  ${entityNameLower});
    int count(${entityName}  ${entityNameLower});

    List<${entityName}> selectForPage(Page<${entityName}> page, @Param("${entityNameLower}")${entityName} ${entityNameLower});
}
