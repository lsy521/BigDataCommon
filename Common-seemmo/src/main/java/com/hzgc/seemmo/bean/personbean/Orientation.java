package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//行人方向
@Data
public class Orientation implements Serializable {

    private String code;
    private String name;

}
