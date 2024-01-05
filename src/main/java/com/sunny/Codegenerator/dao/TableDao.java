package com.sunny.Codegenerator.dao;

import com.sunny.Codegenerator.entity.Table;

import java.util.List;

public interface TableDao {
    List<Table> getList(Table table);
}
