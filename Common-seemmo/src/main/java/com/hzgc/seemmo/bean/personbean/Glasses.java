package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//眼镜
@Data
public class Glasses implements Serializable {

    private String code;
    private String name;

}

class GlassesName{
    private static final HashMap<String,String> glassesName = new HashMap <>();

    public GlassesName() {
        glassesName.put("1","无眼镜");
        glassesName.put("2","戴眼镜");
    }

    public String getGlassesName(String code){
        return glassesName.get(code);
    }
}
