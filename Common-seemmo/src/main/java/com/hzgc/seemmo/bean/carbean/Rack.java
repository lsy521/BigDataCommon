package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//是否有行李架
@Data
public class Rack implements Serializable {

    private String code;
    private String name;
}
