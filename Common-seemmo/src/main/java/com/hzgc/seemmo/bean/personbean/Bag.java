package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//背包
@Data
public class Bag implements Serializable {

    private String code;
    private String name;
}

class BagName{

    private static final HashMap<String,String> bagName = new HashMap <>();

    public BagName() {
        bagName.put("1","未拎东西");
        bagName.put("2","拎东西");
    }

    public String getBagName(String code){
        return bagName.get(code);
    }
}
