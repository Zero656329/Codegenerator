package com.sunny.Codegenerator.controller;


import com.sunny.Codegenerator.Service.AuthDictService;
import com.sunny.Codegenerator.entity.AuthDict;
import com.sunny.Codegenerator.entity.SapFuzhu;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RequestMapping(value = "/authDict")
@RestController
public class AuthDictController {

    @Resource
    AuthDictService authDictService;


    @PostMapping(value = "/add")

    public Object add(@RequestBody AuthDict authDict) {
        if (authDict == null || null == authDict.getId()) {
            return "sucess";
        }
        SapFuzhu result = authDictService.getFuzhu(authDict);
        authDictService.FuzhuToAuthdict(new BigDecimal(0),result);
        return "sucess";

    }


}
