package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

//危险车
@Data
public class Danger implements Serializable {

    private boolean hasDanger;
}
