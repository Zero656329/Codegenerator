package com.sunny.Codegenerator.entity;

import lombok.Data;

@Data
public class TableColumnInfo {
    private String columnName;
    private String dataType;
    private String isNullable;

}
