package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//年龄
@Data
public class Age implements Serializable {

    private String code;
    private String name;
}

class AgeName{

    private static final HashMap<String,String> ageName = new HashMap <>();

    public AgeName() {
        ageName.put("1","儿童");
        ageName.put("2","青年");
        ageName.put("3","中年");
        ageName.put("4","老年");
        ageName.put("5","少年");
    }

    public String getAgeName(String code){
        return ageName.get(code);
    }
}
