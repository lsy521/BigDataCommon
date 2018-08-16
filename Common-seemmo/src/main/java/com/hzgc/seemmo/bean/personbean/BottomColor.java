package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//下衣颜色
@Data
public class BottomColor implements Serializable {

    private String code;
    private String name;
}

class BottomColorName{

    private static final HashMap<String,String> bottomColorName = new HashMap <>();

    public BottomColorName() {
        bottomColorName.put("1","灰");
        bottomColorName.put("2","白");
        bottomColorName.put("3","红");
        bottomColorName.put("4","绿");
        bottomColorName.put("5","蓝");
        bottomColorName.put("6","黄");
        bottomColorName.put("7","黑");
        bottomColorName.put("8","紫");
        bottomColorName.put("9","深灰");
    }

    public String getBottomColorName(String code){
        return bottomColorName.get(code);
    }
}
