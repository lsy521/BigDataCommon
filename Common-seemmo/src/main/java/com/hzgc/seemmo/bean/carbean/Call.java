package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//是否打电话
@Data
public class Call implements Serializable {

    private boolean hasCall;
}
