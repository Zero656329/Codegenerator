package com.sunny.Codegenerator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

@Data
public class AuthDict implements Serializable {

    private static final long serialVersionUID = 1L;


    
    private BigDecimal id;
    
    private String cxuhao;
    
    private String cname;
    
    private BigDecimal nparent;
    
    private String ccreate;
    
    private Date dcreate;
    
    private BigDecimal nsysid;
    
    private String cstr1;
    
    private String cstr2;
    
    private String cstr3;
    
    private String cstr4;
    
    private String cstr5;
    
    private String cstr6;
    
    private String cstr7;
    
    private String cstr8;
    
    private String cstr9;
    
    private String cstr10;

    private Date ts;

    private List<AuthDict> authDictList;
}
