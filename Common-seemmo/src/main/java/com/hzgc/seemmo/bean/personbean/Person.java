package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//行人对象
@Data
public class Person implements Serializable {

    private Recognize  recognize;
}
