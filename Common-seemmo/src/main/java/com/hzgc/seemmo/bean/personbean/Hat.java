package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//帽子类型
@Data
public class Hat implements Serializable {

    private String code;
    private String name;
}

class HatName{

    private static final HashMap<String,String> hatName = new HashMap <>();

    public HatName() {
        hatName.put("1","未戴帽子");
        hatName.put("2","戴帽子");
        hatName.put("3","戴头盔");
    }

    public String getHatName(String code){
        return hatName.get(code);
    }
}
