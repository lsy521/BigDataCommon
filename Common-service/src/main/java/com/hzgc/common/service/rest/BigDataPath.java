package com.hzgc.common.service.rest;

/**
 * 大数据接口请求路径
 */
public class BigDataPath {

    /**
     * 大数据路径
     */
    private static final String ROOT = "";

    /**
     * ftp模块请求路径
     */
    public static final String FTP_GET_PROPERTIES = "/ftp_info";
    public static final String FTP_GET_IP = "/hostname_convert";
    public static final String FTP_SUBSCRIPTION_OPEN = "/subscribe_open";
    public static final String FTP_SUBSCRIPTION_CLOSE = "/subscribe_close";

    /**
     * Clustering模块请求路径
     */
    public static final String PEOPLEIN_SEARCH = "/peoplein_search";
    public static final String PEOPLEIN_TOTLE = "/peoplein_totle";
    public static final String PEOPLEIN_DETAILSEARCH_V1 = "/peoplein_detail";
    public static final String PEOPLEIN_DELETE = "/peoplein_delete";
    public static final String PEOPLEIN_IGNORE = "/peoplein_ignore";
    public static final String PEOPLEIN_MOVEIN="/peoplein_movein";
    public static final String PEOPLEIN_LOCUS="/peoplein_locus";

    public static final String PEOPLEMANAGER_SAVEPLAN ="/peoplemanager_saveplan";
    public static final String PEOPLEMANAGER_SEARCHPLAN = "/peoplemanager_searchplan";
    public static final String PEOPLEMANAGER_MODIFYPLAN = "/peoplemanager_modifyplan";
    public static final String PEOPLEMANAGER_DELETEPLAN = "/peoplemanager_deleteplan";
    public static final String PEOPLEMANAGER_ADDPERSON="/peoplemanager_addperson";
    public static final String PEOPLEMANAGER_DELETEPERSON="/peoplemanager_deleteperson";
    public static final String PEOPLEMANAGER_MODIFYPERSON="/peoplemanager_modifyperson";
    public static final String PEOPLEMANAGER_GETPERSON="/peoplemanager_getperson";
    public static final String PEOPLEMANAGER_PERSONSEARCH="/peoplemanager_personsearch";;
    public static final String PEOPLEMANAGER_CAPTURECOUNT="/peoplemanager_capturecount";
    public static final String PEOPLEMANAGER_CAPTUREHISTORY="/peoplemanager_capturehistory";
    public static final String PEOPLEMANAGER_RESIDENTSEARCH="/peoplemanager_residentsearch";
    public static final String PEOPLEMANAGER_GETRESIDENTPICTURE="/peoplemanager_getresidentpicture";
    public static final String PEOPLEMANAGER_CAPTURELOCUS="/peoplemanager_capturelocus";


    /**
     * Device模块请求路径
     */
    public static final String DEVICE = ROOT + "/device";
    public static final String DEVICE_BIND = "/bindDevice";
    public static final String DEVICE_UNBIND = "/unbindDevice";
    public static final String DEVICE_RENAMENOTES = "/renameNotes";

    public static final String WARNRULE = ROOT + "/warnRule";
    public static final String WARNRULE_CONFIG = "/configRules";
    public static final String WARNRULE_ADD = "/addRules";
    public static final String WARNRULE_GETCOMPARE = "/getCompareRules";
    public static final String WARNRULE_DELETE = "/deleteRules";
    public static final String WARNRULE_OBJECTTYPE_GET = "/objectTypeHasRule";
    public static final String WARNRULE_OBJECTTYPE_DELETE = "/deleteObjectTypeOfRules";

    /**
     * DynRepo模块请求路径
     */
    public static final String DYNREPO_SEARCH = "/search_picture";
    public static final String DYNREPO_SEARCHRESULT = "/search_result";
    public static final String DYNREPO_GETPICTURE = "/origin_picture";
    public static final String DYNREPO_HISTORY = "/capture_history";
    public static final String CAR_DYNREPO_HISTORY = "/car_capture_history";
    public static final String DYNREPO_SEARCHHISTORY="/search_history";
    public static final String DYNREPO_CAPTURE_LASTTIME="/capture_last_time";

    /**
     * Face模块请求路径
     */
    public static final String FEATURE_EXTRACT_BIN = "/extract_bin";
    public static final String FEATURE_EXTRACT_FTP = "/extract_ftp";
    public static final String FACE_ATTRIBUTE = "/attribute";
    public static final String FEATURE_EXTRACT_BYTES = "/extract_bytes";
    public static final String CAR_ATTRIBUTE = "/car_attribute";
    public static final String CAR_CAPTURE = "/car_capture";
    public static final String CAR_EXTRACT = "/car_extract";

    /**
     * StaRepo模块请求路径
     */
    public static final String OBJECTINFO_ADD = "/object_add";
    public static final String OBJECTINFO_DELETE = "/object_delete";
    public static final String OBJECTINFO_UPDATE = "/object_update";
    public static final String OBJECTINFO_UPDATE_STATUS = "/object_update_status";
    public static final String OBJECTINFO_GET = "/object_get";
    public static final String OBJECTINFO_GET_CARE_PEOPLE = "/get_care_people";
    public static final String OBJECTINFO_GET_STATUS_PEOPLE = "/get_status_people";
    public static final String OBJECTINFO_GET_IMPORTANT_PEOPLE = "/get_important_people";
    public static final String OBJECTINFO_SEARCH = "/object_search";
    public static final String OBJECTINFO_GET_PHOTOBYKEY = "/get_object_photo";
    public static final String OBJECTINFO_GET_FEATURE = "/get_feature";
    public static final String STAREPO_GET_SEARCHRESULT= "/get_search_result";
    public static final String STAREPO_GET_SEARCHPHOTO = "/get_search_photo";
    public static final String STAREPO_CREATE_WORD = "/create_word";
    public static final String STAREPO_EXPORT_WORD = "/export_word";
    public static final String OBJECTINFO_COUNT_STATUS = "/count_status";
    public static final String STAREPO_COUNT_EMIGRATION = "/count_emigration";

    public static final String TYPE_ADD = "/type_add";
    public static final String TYPE_DELETE = "/type_delete";
    public static final String TYPE_UPDATE = "/type_update";
    public static final String TYPE_SEARCH = "/type_search";
    public static final String TYPE_SEARCH_NAMES = "/type_search_names";

    /**
     * visual模块请求路径
     */
    public static final String CAPTURECOUNT_DYNREPO = "/capture_day_count";
    public static final String CAPTURECOUNT_IPCIDS_TIME = "/face_hours";
    public static final String CAPTURECOUNT_SIX_HOUR = "/sixhours_count";
    public static final String CAPTURECOUNT_IPCIDS = "/face";
    public static final String PEOPLE_COUNT="/people_count";
    public static final String GET_PICTURE = "/image";
    public static final String GET_CARE_PEOPLE = "/get_care_people";
    public static final String GET_STATUS_PEOPLE = "/get_status_people";
    public static final String GET_IMPORTANT_PEOPLE = "/get_important_people";

    /**
     * Dispatch模块请求路径
     */
    public static final String DISPATCH_ADD = "/add_rule";
    public static final String DISPATCH_MODIFY = "/modify_rule";
    public static final String DISPATCH_DELETE = "/delete_rules";
    public static final String DISPATCH_SEARCH_BYID = "/rule_info";
    public static final String DISPATCH_CUTPAGE_RULE = "/get_rule";

    /**
     * Dispatch模块请求路径
     */
    public static final String ALARM__QUERY = "/alarm_info";

    /**
     *Discar模块请求路径
     */
    public static final String DYNCAR_CAPTURE_HISTORY = "/vehicle_history";

    /**
     * DynPerson模块请求路径
     */
    public static final String PERSON_ATTRIBUTE= "/person_attribute" ;
    public static final String CAPTURE_HISTORY= "/person_capture_history" ;
    public static final String PERSON_FEATURE_EXTRACT_BIN = "/person_extract_bin";


}