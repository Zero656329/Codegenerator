package com.sunny.Codegenerator.Service;

import com.sunny.Codegenerator.entity.Table;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface GeneratorService {
   Integer generator(Table table) throws Exception;

  void generatorZip(Table table, HttpServletResponse response) throws Exception;

}
