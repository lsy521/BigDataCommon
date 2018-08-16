package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//性别
@Data
public class Sex implements Serializable {

    private String code;
    private String name;

}
