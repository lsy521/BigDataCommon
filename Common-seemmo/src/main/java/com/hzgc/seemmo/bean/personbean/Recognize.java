package com.hzgc.seemmo.bean.personbean;

import lombok.Data;

import java.io.Serializable;

//识别出来的信息
@Data
public class Recognize implements Serializable{

    private TrolleyCase trolleyCase;
    private ShoulderBag shoulderBag;
    private BottomType bottomType;
    private Umbrella umbrella;
    private Orientation orientation;
    private MessengerBag messengerBag;
    private UpperType upperType;
    private Age age;
    private UpperColor upperColor;
    private Mask mask;
    private Sex sex;
    private Hair hair;
    private Bag bag;
    private Knapsack knapsack;
    private Baby baby;
    private UpperTexture upperTexture;
    private Glasses glasses;
    private Hat hat;
    private BottomColor bottomColor;
    private Barrow barrow;
}
