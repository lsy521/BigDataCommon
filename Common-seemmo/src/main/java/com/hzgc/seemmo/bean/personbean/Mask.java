package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//戴口罩
@Data
public class Mask implements Serializable {

    private String code;
    private String name;

}

class MaskName{
    private static final HashMap<String,String> maskName = new HashMap <>();

    public MaskName() {
        maskName.put("1","无口罩");
        maskName.put("2","戴口罩");
    }

    public String getMaskName(String code){
        return maskName.get(code);
    }
}
