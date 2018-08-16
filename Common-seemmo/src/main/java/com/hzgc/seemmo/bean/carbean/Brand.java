package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//车型
@Data
public class Brand implements Serializable {

    private String code;
    private String name;
}
