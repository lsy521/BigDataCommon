package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Recognize implements Serializable {

    //车辆对象类型
    private Integer vehicle_object_type;
    //主驾驶安全带
    private Integer belt_mainDriver;
    //副驾驶安全带
    private Integer belt_coDriver;
    //车的商标
    private String brand_name;
    //打电话
    private Integer call_code;
    //车辆颜色
    private Integer vehicle_color;
    //撞损
    private Integer crash_code;
    //危化品车
    private Integer danger_code;
    //小物品检测
    private Integer marker_code;
    //车牌污损
    private Integer plate_schelter_code;
    //车牌标识
    private Integer plate_flag_code;
    //车牌号
    private String plate_licence;
    //车牌是否遮挡
    private Integer plate_destain_code;
    //车牌颜色
    private Integer plate_color_code;
    //车牌类型
    private Integer plate_type_code;
    //行李架
    private String rack_code;
    //备用轮胎
    private Integer spareTire_code;
    //车辆行驶方向
    private String mistake_code;
    //天窗
    private Integer sunroof_code;
    //车辆类型
    private String vehicle_type;
    //车辆类型
    private Integer vehicle_kind_code;
}
