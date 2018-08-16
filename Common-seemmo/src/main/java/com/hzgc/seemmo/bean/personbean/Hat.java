package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//帽子类型
@Data
public class Hat implements Serializable {

    private String code;
    private String name;

}
