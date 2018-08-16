package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

//车牌bean
@Data
public class Plate implements Serializable {
    //是否污损
    private boolean schelter;
    //车牌标识
    private int flag;
    //车牌标识描述
    private String flagDesc;
    //车牌号
    private String licence;
    //是否遮挡
    private boolean destain;
    //车牌颜色码
    private String colorCode;
    //车辆颜色描述
    private String colorDesc;
    //车牌类型码
    private int type;
    //车牌类型描述
    private String typeDesc;

    private static final PlateIndex plateIndex = new PlateIndex();

    public String getFlagDesc() {
        return this.flagDesc != null ? this.flagDesc : plateIndex.getFlagDesc(this.flag);
    }

    public void setFlagDesc(String flagDesc) {
        this.flagDesc = flagDesc;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        this.flagDesc = plateIndex.getFlagDesc(flag);
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
        this.colorDesc = plateIndex.getColorDesc(colorCode);
    }

    public String getColorDesc() {
        return colorDesc != null ? colorDesc : plateIndex.getColorDesc(colorCode);
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        this.typeDesc = plateIndex.getTypeDesc(type);
    }

    public String getTypeDesc() {
        return typeDesc != null ? typeDesc : plateIndex.getTypeDesc(type);
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}

class PlateIndex {

    private static final HashMap<Integer, String> plateType = new HashMap <>();
    private static final HashMap<String, String> plateColor = new HashMap <>();
    private static final HashMap<Integer, String> plateFlag= new HashMap <>();

    public PlateIndex() {
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

        plateColor.put("1","黄");
        plateColor.put("2","蓝");
        plateColor.put("3","黑");
        plateColor.put("4","白");

        plateFlag.put(0,"空牌");
        plateFlag.put(1,"单牌");
        plateFlag.put(2,"双牌");
        plateFlag.put(3,"非车牌");
        plateFlag.put(4,"车牌太小");
        plateFlag.put(5,"车牌未检测到");
    }

    public HashMap <Integer, String> getPlateType() {
        return plateType;
    }

    public String getTypeDesc(Integer type) {
        return plateType.get(type);
    }
    public String getColorDesc(String colorCode) {
        return plateColor.get(colorCode);
    }
    public String getFlagDesc(Integer flag) {
        return plateFlag.get(flag);
    }
}