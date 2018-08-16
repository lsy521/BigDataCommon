package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//手推车
@Data
public class Barrow implements Serializable {

    private String code;
    private String name;

}

class BarrowName{

    private static final HashMap<String,String> barrowName = new HashMap <>();

    public BarrowName() {
        barrowName.put("1","无手推车");
        barrowName.put("2","有手推车");
    }

    public String getBarrowName(String code){
        return barrowName.get(code);
    }
}
