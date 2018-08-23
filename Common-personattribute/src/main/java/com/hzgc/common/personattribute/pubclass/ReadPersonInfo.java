package com.hzgc.common.personattribute.pubclass;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ReadPersonInfo {

    private final Map<String,Map<String,String>> personMap = new HashMap<>();
    public ReadPersonInfo() {
        personMap.put("age",ReadPersonInfo.ageInfo());
        personMap.put("baby",ReadPersonInfo.babyInfo());
        personMap.put("bag",ReadPersonInfo.bagInfo());
        personMap.put("bottomColor",ReadPersonInfo.bottomColorInfo());
        personMap.put("bottomType",ReadPersonInfo.bottomTypeInfo());
        personMap.put("hat",ReadPersonInfo.hatInfo());
        personMap.put("hair",ReadPersonInfo.hairInfo());
        personMap.put("knapsack",ReadPersonInfo.knapsackInfo());
        personMap.put("messengerBag",ReadPersonInfo.messengerBagInfo());
        personMap.put("orientation",ReadPersonInfo.orientationInfo());
        personMap.put("sex",ReadPersonInfo.sexInfo());
        personMap.put("shoudlerBag",ReadPersonInfo.shoulderBagInfo());
        personMap.put("umbrella",ReadPersonInfo.umbrellaInfo());
        personMap.put("upperColor",ReadPersonInfo.upperColorInfo());
        personMap.put("upperType",ReadPersonInfo.upperTypeInfo());
        personMap.put("type",ReadPersonInfo.objectTypeInfo());
    }

    private static Map<String,String> ageInfo(){
        HashMap <String, String> ageMap = new HashMap <>();
        ageMap.put("1","儿童");
        ageMap.put("2","青年");
        ageMap.put("3","中年");
        ageMap.put("4","老年");
        ageMap.put("5","少年");
        return ageMap;
    }

    private static Map<String,String> babyInfo() {
        HashMap <String, String> babyMap = new HashMap <>();
        babyMap.put("1","抱小孩");
        babyMap.put("2","未抱小孩");
        babyMap.put("3","背小孩");
        return babyMap;
    }

    private static Map<String,String> bagInfo() {
        HashMap <String, String> bagMap = new HashMap <>();
        bagMap.put("1","未拎东西");
        bagMap.put("2","拎东西");
        return bagMap;
    }

    private static Map<String,String> bottomColorInfo() {
        HashMap <String, String> bottomColorMap = new HashMap <>();
        bottomColorMap.put("1","灰");
        bottomColorMap.put("2","白");
        bottomColorMap.put("3","红");
        bottomColorMap.put("4","绿");
        bottomColorMap.put("5","蓝");
        bottomColorMap.put("6","黄");
        bottomColorMap.put("7","黑");
        bottomColorMap.put("8","紫");
        bottomColorMap.put("9","深灰");
        return bottomColorMap;
    }

    private static Map<String,String> bottomTypeInfo() {
        HashMap <String, String> bottomTypeMap = new HashMap <>();
        bottomTypeMap.put("1","长裤");
        bottomTypeMap.put("2","短裤");
        bottomTypeMap.put("3","七分裤");
        bottomTypeMap.put("4","裙子");
        return bottomTypeMap;
    }

    private static Map<String,String> hatInfo() {
        HashMap <String, String> hatMap = new HashMap <>();
        hatMap.put("1","未戴帽子");
        hatMap.put("2","戴帽子");
        hatMap.put("3","戴头盔");
        return hatMap;
    }

    private static Map<String,String> hairInfo() {
        HashMap <String, String> hairMap = new HashMap <>();
        hairMap.put("1","长发");
        hairMap.put("2","短发");
        hairMap.put("3","马尾");
        hairMap.put("4","头部被遮挡");
        hairMap.put("5","盘发");
        return hairMap;
    }

    private static Map<String,String> knapsackInfo() {
        HashMap <String, String> knapsackMap = new HashMap <>();
        knapsackMap.put("1","未背双肩包");
        knapsackMap.put("2","双肩包(有包)");
        knapsackMap.put("3","未确定");
        return knapsackMap;
    }

    private static Map<String,String> messengerBagInfo() {
        HashMap <String, String> messengerBagMap = new HashMap <>();
        messengerBagMap.put("1","非斜挎包");
        messengerBagMap.put("2","斜挎包");
        return messengerBagMap;
    }

    private static Map<String,String> orientationInfo() {
        HashMap <String, String> orientationMap = new HashMap <>();
        orientationMap.put("1","前");
        orientationMap.put("2","后");
        orientationMap.put("3","侧");
        return orientationMap;
    }

    private static Map<String,String> sexInfo() {
        HashMap <String, String> sexMap = new HashMap <>();
        sexMap.put("1","男");
        sexMap.put("2","女");
        return sexMap;
    }

    private static Map<String,String> shoulderBagInfo() {
        HashMap <String, String> shoulderBagMap = new HashMap <>();
        shoulderBagMap.put("1","非单肩包");
        shoulderBagMap.put("2","单肩包");
        return shoulderBagMap;
    }

    private static Map<String,String> umbrellaInfo() {
        HashMap <String, String> umbrellaMap = new HashMap <>();
        umbrellaMap.put("1","未打伞");
        umbrellaMap.put("2","打伞");
        return umbrellaMap;
    }

    private static Map<String,String> upperColorInfo() {
        HashMap <String, String> upperColorMap = new HashMap <>();
        upperColorMap.put("1","灰");
        upperColorMap.put("2","白");
        upperColorMap.put("3","红");
        upperColorMap.put("4","绿");
        upperColorMap.put("5","蓝");
        upperColorMap.put("6","黄");
        upperColorMap.put("7","黑");
        upperColorMap.put("8","紫");
        upperColorMap.put("9","深灰");
        return upperColorMap;
    }

    private static Map<String,String> objectTypeInfo() {
        HashMap <String, String> objectTypeMap = new HashMap <>();
        objectTypeMap.put("0","未知类型");
        objectTypeMap.put("1","行人");
        objectTypeMap.put("2","自行车");
        objectTypeMap.put("3","摩托车");
        objectTypeMap.put("4","小汽车");
        objectTypeMap.put("5","三轮车");
        objectTypeMap.put("6","巴士");
        objectTypeMap.put("7","面包车");
        objectTypeMap.put("8","卡车");
        return objectTypeMap;
    }

    private static Map<String,String> upperTypeInfo() {
        HashMap <String, String> upperTypeMap = new HashMap <>();
        upperTypeMap.put("1","长袖");
        upperTypeMap.put("2","短袖");
        upperTypeMap.put("3","羽绒服");
        upperTypeMap.put("4","普通外套");
        upperTypeMap.put("5","无外套");
        return upperTypeMap;
    }

    public Map<String,Map<String,String>> getPersonMap(){
        return personMap;
    }
}
