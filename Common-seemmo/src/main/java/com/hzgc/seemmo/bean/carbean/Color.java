package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

//车的颜色
@Data
public class Color implements Serializable {

    //车辆颜色码
    private String code;
    //车辆颜色名称
    private String name;

}

class ColorName{

    private static final HashMap<Integer,String> carColor = new HashMap <>();

    public ColorName() {
        carColor.put(1,"黑色");
        carColor.put(2,"蓝色");
        carColor.put(3,"棕色");
        carColor.put(4,"绿色");
        carColor.put(5,"灰色");
        carColor.put(6,"白色");
        carColor.put(7,"红色");
        carColor.put(8,"黄色");
        carColor.put(9,"粉色");
        carColor.put(10,"紫色");
        carColor.put(11,"青色");
        carColor.put(12,"深灰色");
        carColor.put(13,"金色");
    }

    public String getCarName(Integer code){
        return carColor.get(code);
    }
}
