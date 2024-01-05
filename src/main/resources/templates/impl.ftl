package ${basePackageUrl}.service.impl;
import com.sunny.pagehelper.Page;
import ${basePackageUrl}.entity.${entityName};
import ${basePackageUrl}.mapper.${entityName}Mapper;
import ${basePackageUrl}.service.${entityName}Service;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import ${basePackageUrl}.dto.${entityName}Dto;
import ${basePackageUrl}.annotation.EnablePaging;
import javax.annotation.Resource;
@Service
public class ${entityName}ServiceImpl extends BaseServiceManager implements ${entityName}Service {

@Resource
${entityName}Mapper ${entityNameLower}Mapper;

@Override
public ${entityName} getObjectById(BigDecimal id) {
return ${entityNameLower}Mapper.getObjectById(id);
}


@Override
@EnablePaging
public Page selectForPage(${entityName}Dto ${entityNameLower}Dto) {
Page<${entityName}> page = new Page<${entityName}>(${entityNameLower}Dto.getPageNo(),${entityNameLower}Dto.getPageSize());
        List<${entityName}>list = ${entityNameLower}Mapper.selectForPage(page,mdmOppointDto.getMdmOppoint());
            page.setRecords(list);
            return page;
}


@Override
public Boolean delete(String ids) {
String[] id = ids.split(",");
List<String> idList = Arrays.asList(id);
    Integer num =  ${entityNameLower}Mapper.deleteByIds(idList);
    if (num > 0) {
    return true;
    } else {
    return false;
    }
    }
    @Override
    public Boolean update(${entityName} ${entityNameLower}) {
    Integer num = ${entityNameLower}Mapper.updateByPrimaryKeySelective(${entityNameLower});
    if (num > 0) {
    return true;
    }
    return false;
    }

    @Override
    public Boolean add(${entityName} ${entityNameLower}) {

    Integer num = ${entityNameLower}Mapper.insert(${entityNameLower});
    if (num > 0) {
    return true;
    }
    return false;
    }
}
