package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//小物品检测
@Data
public class Marker implements Serializable {

    private int code;
    private String message;
}
