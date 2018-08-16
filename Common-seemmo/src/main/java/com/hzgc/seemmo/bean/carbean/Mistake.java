package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//车的行驶方向
@Data
public class Mistake implements Serializable {

    private String code;
    private String name;
}
