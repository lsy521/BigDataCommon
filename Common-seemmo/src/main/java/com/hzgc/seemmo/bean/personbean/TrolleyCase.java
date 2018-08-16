package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//拉杆箱
@Data
public class TrolleyCase implements Serializable {

    private String code;
    private String name;

}

class TrolleyCaseName{

    private static final HashMap<String,String> trolleyCaseName = new HashMap <>();

    public TrolleyCaseName() {
        trolleyCaseName.put("1","无拉杆箱");
        trolleyCaseName.put("2","有拉杆箱");
    }

    public String getTrolleyCaseName(String code){
        return trolleyCaseName.get(code);
    }
}
