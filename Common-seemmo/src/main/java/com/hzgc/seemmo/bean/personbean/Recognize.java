package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//识别出来的信息 es中的type
@Data
public class Recognize implements Serializable{

    //年龄
    private String age_code;
    //小孩类型
    private String baby_code;
    //拎东西
    private String bag_code;
    //下衣颜色
    private String bottomColor_code;
    //下衣类型
    private String bottomType_code;
    //帽子类型
    private String hat_code;
    //发型
    private String hair_code;
    //双肩包
    private String knapsack_code;
    //斜挎包
    private String messengerBag_code;
    //行人方向
    private String orientation_code;
    //性别
    private String sex_code;
    //单肩包
    private String shoulderBag_code;
    //雨伞
    private String umbrella_code;
    //上衣颜色
    private String upperColor_code;
    //上衣类型
    private String upperType_code;
    //骑车的类型
    private Integer car_type;
    //骑车的图片数据
    private float[] car_data;
}
