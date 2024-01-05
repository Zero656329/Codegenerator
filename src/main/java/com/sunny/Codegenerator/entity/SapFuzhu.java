package com.sunny.Codegenerator.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SapFuzhu implements Serializable {

private static final long serialVersionUID = 1L;

        private BigDecimal id;
        private String cname;
        private String cxuhao;
        private String cdate;
        private String ddateAfter;
        private String ddateBefore;
        private Date ddate;
        private BigDecimal nstaff;
        private BigDecimal nleibie;
        private BigDecimal nbz;
        private String cyanse;
        private String nzlzx;
        private BigDecimal nbiaozhi;
        private BigDecimal nsftf;
        private BigDecimal ndqbz;
        private BigDecimal nxmlb;
        private BigDecimal nqybz;
        private BigDecimal nsfmrp;
        private Date djzrq;
        private Date dsxrq;
        private String cgnfw;
        private String cdjbz;
        private BigDecimal ngongxu;
        private String cglf;
        private BigDecimal nsfhd;
        private BigDecimal nmrpspr;
        private String czytj;
        private String ctjlx;
        private String cjhlb;
        private String cspr1;
        private String cspr2;
        private String cspr3;
        private String cfplx;
        private String cjc;
        private BigDecimal fjc;
        private String cjbdwlx;
        private BigDecimal ngcbz;
        private BigDecimal npaixu;
        private String cchdlx;
        private BigDecimal nfktjts;
        private Date ts;
        private BigDecimal ncgddsxs;
        private String cltc;
        private BigDecimal nsfmes;
        private BigDecimal nsfhwgl;
        private String cnameen;

        private BigDecimal nsfyw;
        private String cgj;
        private BigDecimal nwmstype;
        private String cifmsbh;
        private String csapnumb;

        private List<SapFuzhu> sapFuzhuList;

}
