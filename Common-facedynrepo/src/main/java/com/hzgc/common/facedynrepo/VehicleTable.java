package com.hzgc.common.facedynrepo;

import java.io.Serializable;

public class VehicleTable implements Serializable{

    //es索引
    public static final String VEHICLE_INDEX = "vehicle";
    //es类型
    public static final String VEHICLE_TYPE = "recognize";
    //设备id
    public static final String IPCID = "ipcid";
    //时间区间 数据格式 小时+分钟 例如:11:30用1130表示
    public static final String TIMESLOT = "timeslot";
    //时间戳 数据格式 xxxx-xx-xx xx:xx:xx(年-月-日 时:分:秒)
    public static final String TIMESTAMP = "timestamp";
    //日期 分区字段 数据格式 xxxx-xx-xx(年-月-日)
    public static final String DATE = "date";
    //车的商标
    public static final String BRAND_NAME = "brand_name";
    //车牌
    public static final String PLATE_LICENCE = "plate_licence";
    //分词器
    public static final String IK_SMART = "ik_smart";
}
