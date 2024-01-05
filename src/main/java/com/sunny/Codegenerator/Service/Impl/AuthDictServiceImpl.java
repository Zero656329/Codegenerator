package com.sunny.Codegenerator.Service.Impl;

import com.sunny.Codegenerator.Service.AuthDictService;
import com.sunny.Codegenerator.dao.AuthDictMapper;
import com.sunny.Codegenerator.dao.SapFuzhuMapper;
import com.sunny.Codegenerator.entity.AuthDict;
import com.sunny.Codegenerator.entity.SapFuzhu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthDictServiceImpl implements AuthDictService {
    @Resource
    private AuthDictMapper authDictMapper;
    @Resource
    private SapFuzhuMapper sapFuzhuMapper;

    @Override
    public AuthDict FuzhuToAuthdict(BigDecimal nparent,SapFuzhu sapFuzhu) {
        if (null == sapFuzhu) {
            return null;
        }
        AuthDict authDict = new AuthDict();
        authDict.setCname(sapFuzhu.getCname());
        authDict.setCxuhao(sapFuzhu.getCxuhao());
        authDict.setCstr2(sapFuzhu.getNzlzx());
        authDict.setNparent(nparent);
         authDictMapper.insert(authDict);
        List<SapFuzhu> sapFuzhuList = sapFuzhu.getSapFuzhuList();

        if (null != sapFuzhuList && sapFuzhuList.size() > 0) {
            BigDecimal id = authDict.getId();

            for (int i = 0; i < sapFuzhuList.size(); i++) {
                SapFuzhu fuzhu=  sapFuzhuList.get(i);
                FuzhuToAuthdict(id,fuzhu);
            }
        }

        return authDict;
    }

    @Override
    public Boolean insert(AuthDict authDict) {
        if (null == authDict) {
            return false;
        }
        Integer result = authDictMapper.insert(authDict);
        if (result == 0) {
            return false;
        }
        List<AuthDict> authDictList = authDict.getAuthDictList();
        if (null != authDictList && authDictList.size() > 0) {
            BigDecimal id = authDict.getId();
            for (int i = 0; i < authDictList.size(); i++) {
                AuthDict dict = authDictList.get(i);
                dict.setNparent(id);
                this.insert(dict);
            }
        }
        return false;
    }

    @Override
    public SapFuzhu getFuzhu(AuthDict authDict) {

        SapFuzhu sapFuzhu = sapFuzhuMapper.getObjectById(authDict.getId());

        sapFuzhu = getSon(sapFuzhu);


        return sapFuzhu;
    }

    //递归
    SapFuzhu getSon(SapFuzhu sapFuzhu) {
        SapFuzhu sap = new SapFuzhu();
        sap.setNleibie(sapFuzhu.getId());
        List<SapFuzhu> fuzhuList = sapFuzhuMapper.queryList(sap);
        List<SapFuzhu> list = new ArrayList<SapFuzhu>();
        if (null != fuzhuList && fuzhuList.size() > 0) {
            for (int i = 0; i < fuzhuList.size(); i++) {
                SapFuzhu son = fuzhuList.get(i);
                son = getSon(son);
                list.add(son);
            }
            sapFuzhu.setSapFuzhuList(list);

        }
        return sapFuzhu;

    }


    public List<AuthDict> FuzhuToAuthdict(List<SapFuzhu> fuzhuList) {
        if (null == fuzhuList || fuzhuList.size() == 0) {
            return null;
        }
        List<AuthDict> authDictList = new ArrayList<AuthDict>();

        for (int i = 0; i < fuzhuList.size(); i++) {
            SapFuzhu sapfuzhu = fuzhuList.get(i);
            AuthDict authDict = new AuthDict();
            authDict.setCname(sapfuzhu.getCname());
            authDict.setCxuhao(sapfuzhu.getCxuhao());
            authDict.setCstr2(sapfuzhu.getNzlzx());
            authDict.setNparent(sapfuzhu.getNleibie());
            authDictList.add(authDict);

        }
        return authDictList;
    }


}
