package ${basePackageUrl}.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@Data
@ApiModel(value = "${ctablename}")
public class ${entityName} implements Serializable {

private static final long serialVersionUID = 1L;

<#if columns??>
<#--循环生成变量-->
    <#list columns as col>
        @ApiModelProperty(value = "${col["columnName"]}")
        private ${col["columnType"]} ${col["entityColumnNo"]};
    </#list>
    @ApiModelProperty(value = "ids")
    private String ids;
</#if>
}
