package com.sunny.Codegenerator.controller;

import com.sunny.Codegenerator.Service.GeneratorService;
import com.sunny.Codegenerator.entity.Table;
import com.sunny.Codegenerator.util.ZipUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/code")
@Controller
public class CodeController {
    @Resource
    private GeneratorService generatorService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/generator")
    public Object generator(@RequestBody Table table) throws Exception {
        Integer result = generatorService.generator(table);
        if (result == 1) {
            return "sucess";
        } else {
            return "fail";
        }

    }
    @RequestMapping("exportExcelZipWithFile")
    public void exportExcelZipWithFile(@RequestBody Table table,HttpServletResponse response) throws Exception {
        // 这里还是和上面一样
         generatorService.generatorZip(table,response);;

    }


}
