package com.hzgc.common.facealarm.table;

/**
 * 告警有关的es表
 */
public class AlarmTable {

    public static final String INDEX = "alarm";
    public static final String OFF_TYPE = "off_alarm";               //离线告警的type
    public static final String REC_TYPE = "rec_alarm";               //识别告警新增的告警的type
    public final static String IDENTIFY = "100";                      //识别告警
    public final static String ADDED = "101";                          //新增告警
    public final static String OFFLINE = "102";                        //离线告警
    public final static String UNKNOWN = "104";                        //告警不详
}
