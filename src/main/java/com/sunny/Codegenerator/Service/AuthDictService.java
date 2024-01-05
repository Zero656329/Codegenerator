package com.sunny.Codegenerator.Service;

import com.sunny.Codegenerator.entity.AuthDict;
import com.sunny.Codegenerator.entity.SapFuzhu;

import java.math.BigDecimal;
import java.util.List;

public interface AuthDictService {
    AuthDict FuzhuToAuthdict(BigDecimal nparent, SapFuzhu sapFuzhu);



    Boolean insert(AuthDict authDict);

    SapFuzhu getFuzhu(AuthDict authDict);
}
