package ${basePackageUrl}.controller;

import ${basePackageUrl}.entity.${entityName};
import ${basePackageUrl}.service.${entityName}Service;
import ${basePackageUrl}.dto.${entityName}Dto;
import com.sunny.cloud.auth.service.IAuthUserService;
import com.sunny.cloud.auth.interceptor.annotation.AuthIgnore;
import com.sunny.cloud.auth.entity.UserEntity;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import com.sunny.fims.baseframe.utils.PoiUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.sunny.common.model.Result;
@RequestMapping(value = "/${entityNameLower}")
@RestController
@Api(tags = "${ctablename}接口")
public class ${entityName}Controller {

@Resource
${entityName}Service ${entityNameLower}Service;
@Resource
private IAuthUserService authUserService;

@PostMapping(value = "/selectForPage")
@AuthIgnore
@ApiOperation(value = "分页列表查询接口", notes = "分页列表")
public Result selectForPage(@RequestBody ${entityName}Dto ${entityNameLower}Dto) {
if (null == ${entityNameLower}Dto) {
return Result.error("数据为空");
}
return Result.ok(${entityNameLower}Service.selectForPage(${entityNameLower}Dto));
}

@PostMapping(value = "/export")
@ApiOperation(value = "导出接口", notes = "导出数据")
public Object export(@RequestBody ${entityName}Dto ${entityNameLower}Dto, HttpServletResponse response) throws Exception {
String fields = ${entityNameLower}Dto.getFields();
JSONArray jsonArr = new JSONArray(fields);
PageInfo<${entityName}> page = ${entityNameLower}Service.selectForExport(${entityNameLower}Dto);
    PoiUtils.export(page.getList(), jsonArr, "${entityNameLower}", response);
    return Result.ok("导出成功");
    }

@PostMapping(value = "/getObjectById")
@ApiOperation(value = "根据id查询对象接口", notes = "单个对象")
public Result getObjectById(@RequestBody ${entityName} ${entityNameLower}) {
${entityNameLower} = ${entityNameLower}Service.getObjectById(${entityNameLower}.getId());
return Result.ok(${entityNameLower});
}
@PostMapping(value = "/add")
@ApiOperation(value = "新增接口", notes = "新增${ctablename}")
public Result add(@RequestBody ${entityName} ${entityNameLower}) {
if (${entityNameLower} == null) {
return Result.error("没有传入数据");
}
UserEntity currentUserObj = authUserService.getCurrentUserObj();
String cwork = currentUserObj.getUsernumb();
${entityNameLower}.setCwork(cwork);
${entityNameLower}.setNstaff(cwork);
${entityNameLower}.setDdate(new Date());
Boolean result = ${entityNameLower}Service.add(${entityNameLower});
if (result) {
return Result.ok("新增成功");
}
return Result.ok("新增失败");
}
@PostMapping(value = "/edit")
@ApiOperation(value = "编辑接口", notes = "编辑${ctablename}")
public Result edit(@RequestBody ${entityName} ${entityNameLower}) {
if (${entityNameLower} == null) {
return Result.error("没有传入数据");
}
UserEntity currentUserObj = authUserService.getCurrentUserObj();
String cwork = currentUserObj.getUsernumb();
${entityNameLower}.setNstaff(cwork);
Boolean result = ${entityNameLower}Service.update(${entityNameLower});
if (result) {
return Result.ok("编辑成功");
}
return Result.error("编辑失败");
}
@PostMapping(value = "/delete")
@ApiOperation(value = "删除接口", notes = "删除${ctablename}")
public Result delete(@RequestBody ${entityName} ${entityNameLower}) {
String ids=${entityNameLower}.getIds();
if (StringUtils.isNotBlank(ids)) {
Boolean result = ${entityNameLower}Service.delete(ids);
if (result) {
return Result.ok("删除成功");
} else {
return Result.error("删除失败");
}

} else {
return Result.error("没有勾选数据");
}


}
}
