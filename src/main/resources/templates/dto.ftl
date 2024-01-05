package ${basePackageUrl}.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import ${basePackageUrl}.base.dto.BaseDto;
import java.io.Serializable;
import ${basePackageUrl}.entity.${entityName};
import java.util.Date;
@Data
public class ${entityName}Dto extends BaseDto {

private ${entityName}  ${entityNameLower};

@ApiModelProperty(value = "导出字段")
private String fields;
}
