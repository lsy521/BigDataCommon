package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class Vehicle implements Serializable {

    //识别出来的数据
    private Recognize recognize;
    //车的类型码
    private int type;
    //车的类型名
    private String typeDesc;
    //小图路径
    private String carPath;

    private static final VehicleName vehicleName = new VehicleName();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        this.typeDesc = vehicleName.getTypeName(type);
    }

    public String getTypename() {
        return typeDesc != null ? typeDesc : VehicleName.getTypeName(type);
    }

    public void setTypename(String typename) {
        this.typeDesc = typename;
    }
}

class VehicleName{

    private static final HashMap<Integer,String> type = new HashMap <>();

    public VehicleName() {
        type.put(0,"未知类型");
        type.put(1,"行人");
        type.put(2,"自行车");
        type.put(3,"摩托车");
        type.put(4,"小汽车");
        type.put(5,"三轮车");
        type.put(6,"巴士");
        type.put(7,"面包车");
        type.put(8,"卡车");
    }

    public static String getTypeName(Integer integer){
        return type.get(integer);
    }
}
