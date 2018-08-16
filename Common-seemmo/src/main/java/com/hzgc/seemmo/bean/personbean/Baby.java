package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//小孩类型
@Data
public class Baby implements Serializable {
    private String code;
    private String name;
}

class BabyName{

    private static final HashMap<String,String> babyName = new HashMap <>();

    public BabyName() {
        babyName.put("1","抱小孩");
        babyName.put("1","未抱小孩");
        babyName.put("1","背小孩");
    }

    public String getBabyName(String code){
        return babyName.get(code);
    }
}