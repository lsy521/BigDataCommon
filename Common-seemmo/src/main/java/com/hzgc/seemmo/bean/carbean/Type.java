package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//车的类型
@Data
public class Type implements Serializable {

    //车辆类型码
    private String code;
    //车辆类型名称
    private String name;
}

class CarKind{

    private static final HashMap<String,String> carKind = new HashMap <>();

    public CarKind() {
        carKind.put("0","其他");
        carKind.put("1","轿车");
        carKind.put("2","越野车");
        carKind.put("3","商务车");
        carKind.put("4","小型货车");
        carKind.put("5","大型货车");
        carKind.put("6","轻客");
        carKind.put("7","小型客车");
        carKind.put("8","大型客车");
        carKind.put("9","三轮车");
        carKind.put("10","微面");
        carKind.put("11","皮卡车");
        carKind.put("12","挂车");
        carKind.put("13","混凝土搅拌车");
        carKind.put("14","罐车");
        carKind.put("15","随车吊");
        carKind.put("16","消防车");
        carKind.put("17","渣土车");
        carKind.put("18","押运车");
        carKind.put("19","工程抢修车");
        carKind.put("20","救援车");
        carKind.put("21","栏板卡车");
    }

    public String getCarKind(String code){
        return carKind.get(code);
    }
}