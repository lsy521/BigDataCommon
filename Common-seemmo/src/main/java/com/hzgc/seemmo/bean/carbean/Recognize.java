package com.hzgc.seemmo.bean.carbean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Recognize implements Serializable {

    private Plate plate;
    private Crash crash;
    private Danger danger;
    private Color color;
    private Brand brand;
    private Sunroof sunroof;
    private Feature feature;
    private Call call;
    private Marker marker;
    private Mistake mistake;
    private Type type;
    private Rack rack;
    private SpareTire spareTire;
    private Belt belt;
}
