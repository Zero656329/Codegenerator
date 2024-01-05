package com.sunny.Codegenerator.entity;

import java.math.BigDecimal;

public class Tests {
    public static void main(String[] args) {
        String num = "01";
      BigDecimal n=new BigDecimal(num);
       Integer x= n.compareTo(new BigDecimal("09"));
        System.out.println(x);
    }

    static Boolean ts(String num) {
        num = num + "12";
        return false;
    }
}
