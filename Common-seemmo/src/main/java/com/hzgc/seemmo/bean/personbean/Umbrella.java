package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//打伞标记
@Data
public class Umbrella implements Serializable {

    private String code;
    private String name;

}
