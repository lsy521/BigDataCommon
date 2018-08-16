package com.hzgc.seemmo.service;

import java.util.HashMap;
import java.util.Map;

public class ReadCarInfo {

    public Map<Integer,String> getType(Integer key){
        HashMap <Integer, String> objectType = new HashMap <>();
        objectType.put(0,"未知类型");
        objectType.put(1,"行人");
        objectType.put(2,"自行车");
        objectType.put(3,"摩托车");
        objectType.put(4,"小汽车");
        objectType.put(5,"三轮车");
        objectType.put(6,"巴士");
        objectType.put(7,"面包车");
        objectType.put(8,"卡车");

        return objectType;
    }

    public Map<Integer,String> getPlateType(){
        HashMap <Integer, String> plateType = new HashMap <>();
        plateType.put(1,"黄牌(大型汽车)");
        plateType.put(2,"蓝牌(小型汽车)");
        plateType.put(3,"使馆");
        plateType.put(4,"领馆");
        plateType.put(6,"外籍");
        plateType.put(15,"挂车");
        plateType.put(16,"教练车");
        plateType.put(23,"警车");
        plateType.put(26,"港籍");
        plateType.put(27,"澳籍");
        plateType.put(31,"武警");
        plateType.put(32,"军车");
        plateType.put(99,"无法确定");
        return plateType;
    }

    public Map<Integer,String> getPlateColor(){
        HashMap <Integer, String> plateColor = new HashMap <>();
        plateColor.put(1,"黄");
        plateColor.put(2,"蓝");
        plateColor.put(3,"黑");
        plateColor.put(4,"白");
        return plateColor;
    }

    public Map<Integer,String> getCarColor(){
        HashMap <Integer, String> carColor = new HashMap <>();
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
        return carColor;
    }

    public Map<Integer,String> getCarKind(){
        HashMap <Integer, String> carKind = new HashMap <>();
        carKind.put(0,"其他");
        carKind.put(1,"轿车");
        carKind.put(2,"越野车");
        carKind.put(3,"商务车");
        carKind.put(4,"小型货车");
        carKind.put(5,"大型货车");
        carKind.put(6,"轻客");
        carKind.put(7,"小型客车");
        carKind.put(8,"大型客车");
        carKind.put(9,"三轮车");
        carKind.put(10,"微面");
        carKind.put(11,"皮卡车");
        carKind.put(12,"挂车");
        carKind.put(13,"");
        carKind.put(14,"");
        carKind.put(15,"");
        carKind.put(16,"");
        carKind.put(17,"");
        carKind.put(18,"");
        carKind.put(19,"");
        carKind.put(20,"");
        carKind.put(21,"");
        return null;
    }

    public Map<Integer,String> getOtherProperty(){
        HashMap <Integer, String> otherProperty = new HashMap <>();
        return null;
    }
}
