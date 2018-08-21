package com.hzgc.seemmo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzgc.seemmo.bean.ImageResult;
import com.hzgc.seemmo.bean.carbean.*;
import com.hzgc.seemmo.bean.carbean.Recognize;
import com.hzgc.seemmo.bean.personbean.*;
import com.hzgc.seemmo.util.CutImageUtil;
import com.hzgc.seemmo.util.JsonUtil;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageToData {

    private static CloseableHttpClient httpClient = null;

    //httpClient单例
    private static synchronized CloseableHttpClient getHttpClient(){
        if (httpClient == null){
            httpClient = HttpClientBuilder.create().build();
        }
        return httpClient;
    }

    //执行post请求
    public static String executeHttpPost(String url,String imageJsonString){
        try {
            httpClient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(imageJsonString);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse res = httpClient.execute(httpPost);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                return EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取图片详细信息
    public static String getImageResult(String url,String imagePath){
        String imageJsonString = JsonUtil.objectToJsonString(imagePath);
        return ImageToData.executeHttpPost(url, imageJsonString);
    }

    public static String getImageResult(String url,byte[] bytes){
        String imageJsonString = JsonUtil.objectToJsonString(bytes);
        return ImageToData.executeHttpPost(url, imageJsonString);
    }

    //获取数据 0表示获取车的数据，1表示获取人的数据，其他表示获取所有
    @SuppressWarnings("unchecked")
    public ImageResult getData(String result,String imagePath,String tag){
        JSONObject jsonObject = JsonUtil.stringToJsonObject(result);
        JSONObject data = (JSONObject) jsonObject.get("data");
        List<JSONObject> imageResults = (List <JSONObject>) data.get("ImageResults");
        ImageResult imageResult = new ImageResult();
        if ("0".equals(tag)){
            List <Vehicle> vehicleList = ImageToData.getCarData(imageResults,imagePath);
            imageResult.setVehicleLis(vehicleList);
        }
        else if ("1".equals(tag)){
            List <Person> personList = ImageToData.getPersonData(imageResults,imagePath);
            imageResult.setPersonList(personList);
        }
        else {
            List <Vehicle> vehicleList = ImageToData.getCarData(imageResults,imagePath);
            List <Person> personList = ImageToData.getPersonData(imageResults,imagePath);
            imageResult.setVehicleLis(vehicleList);
            imageResult.setPersonList(personList);
            return imageResult;
        }
        return null;
    }

    //数据封装
    @SuppressWarnings("unchecked")
    public static List<Vehicle> getCarData(List<JSONObject> imageResults,String imagePath){
        for (JSONObject js:imageResults){
            List<JSONObject> vehicles = (List <JSONObject>) js.get("Vehicles");
            ArrayList <Vehicle> vehicleList = new ArrayList <>();
            for (JSONObject js1:vehicles){
                Vehicle vehicle = new Vehicle();
                Recognize recognize_object = new Recognize();
                int vehicle_object_type = (int) js1.get("Type");
                recognize_object.setVehicle_object_type(vehicle_object_type);
                JSONObject recognize = (JSONObject) js1.get("Recognize");
                JSONObject detect = (JSONObject) js1.get("Detect");
                JSONObject car = (JSONObject) detect.get("Body");
                JSONArray rect = (JSONArray) car.get("Rect");
                JSONObject plate = (JSONObject) recognize.get("Plate");
                if (null != plate) {
                    int code = (int) plate.get("Code");
                    if (0 == code){
                        JSONObject color = (JSONObject) plate.get("Color");
                        recognize_object.setPlate_color_code(Integer.valueOf((String) color.get("Code")));
                        //1是false，2是true
                        if ((boolean)plate.get("Shelter")){
                            recognize_object.setPlate_schelter_code(2);
                        }else {
                            recognize_object.setPlate_schelter_code(1);
                        }
                        recognize_object.setPlate_flag_code((int)plate.get("Flag"));
                        recognize_object.setPlate_licence((String) plate.get("Licence"));
                        if ((boolean)plate.get("Destain")){
                            recognize_object.setPlate_destain_code(2);
                        }else {
                            recognize_object.setPlate_destain_code(1);
                        }
                        recognize_object.setPlate_type_code((int) plate.get("Type"));
                    }
                }
                JSONObject crash = (JSONObject) recognize.get("Crash");
                if (null != crash){
                    int code = (int) crash.get("Code");
                    if (0 == code){
                        if ((boolean) crash.get("HasCrash")){
                            recognize_object.setCrash_code(2);
                        }else {
                            recognize_object.setCrash_code(1);
                        }
                    }
                }
                JSONObject danger = (JSONObject) recognize.get("Danger");
                if (null != danger){
                    int code = (int) danger.get("Code");
                    if (0 == code){
                        if ((boolean) crash.get("Danger")){
                            recognize_object.setDanger_code(2);
                        }else {
                            recognize_object.setDanger_code(1);
                        }
                    }
                }
                JSONObject color = (JSONObject) recognize.get("Color");
                if (null != color){
                    int code = (int) color.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) color.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setVehicle_color(Integer.valueOf((String) jsonObject1.get("Code")));
                    }
                }
                JSONObject brand = (JSONObject) recognize.get("Brand");
                if (null != brand){
                    int code = (int) brand.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) brand.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setBrand_name((String) jsonObject1.get("Name"));
                    }
                }
                JSONObject sunroof = (JSONObject) recognize.get("Sunroof");
                if (null != sunroof){
                    int code = (int) sunroof.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) sunroof.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setSunroof_code(Integer.valueOf((String) jsonObject1.get("Code")));
                    }
                }
                JSONObject call = (JSONObject) recognize.get("Call");
                if (null != call){
                    int code = (int) call.get("Code");
                    if (0 == code){
                        if ((boolean) call.get("HasCall")){
                            recognize_object.setCall_code(2);
                        }else {
                            recognize_object.setCall_code(1);
                        }
                    }
                }
                JSONObject marker = (JSONObject) recognize.get("Marker");
                if (null != marker){
                    int code = (int) marker.get("Code");
                    if (0 == code){
                        //小物品检测没有处理
                        recognize_object.setMarker_code(2);
                    }else {
                        recognize_object.setMarker_code(1);
                    }
                }
                JSONObject mistake = (JSONObject) recognize.get("Mistake");
                if (null != mistake){
                    int code = (int) mistake.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) mistake.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setMistake_code((String) jsonObject1.get("Code"));
                    }
                }
                JSONObject type = (JSONObject) recognize.get("Type");
                if (null != type){
                    int code = (int) type.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) type.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setVehicle_type((String) jsonObject1.get("Code"));
                    }
                }
                JSONObject rack = (JSONObject) recognize.get("Rack");
                if (null != rack){
                    int code = (int) rack.get("Code");
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) rack.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        recognize_object.setRack_code((String) jsonObject1.get("Code"));
                    }
                }
                JSONObject spareTire = (JSONObject) recognize.get("SpareTire");
                if (null != spareTire){
                    int code = (int) spareTire.get("Code");
                    if (0 == code){
                        if ((boolean) spareTire.get("HasSpareTire")){
                            recognize_object.setSpareTire_code(2);
                        }else {
                            recognize_object.setSpareTire_code(1);
                        }
                    }
                }
                JSONObject belt = (JSONObject) recognize.get("Belt");
                if (null != belt){
                    int code = (int) belt.get("Code");
                    if (0 == code){
                        JSONObject coDriver = (JSONObject) belt.get("CoDriver");
                        if ((boolean) coDriver.get("NoBelt")){
                            recognize_object.setBelt_coDriver(2);
                        }else {
                            recognize_object.setBelt_coDriver(1);
                        }
                        JSONObject mainDriver = (JSONObject) belt.get("MainDriver");
                        if ((boolean) mainDriver.get("NoBelt")){
                            recognize_object.setBelt_mainDriver(2);
                        }else {
                            recognize_object.setBelt_mainDriver(1);
                        }
                    }
                }
                vehicle.setRecognize(recognize_object);
                System.out.println(vehicle);
                //截图车的图片
                CutImageUtil cutImageUtil = new CutImageUtil((int)rect.get(0), (int)rect.get(1), (int)rect.get(2), (int)rect.get(3));
                cutImageUtil.setSrcpath(imagePath);
                String subPath = "";
                cutImageUtil.setSubpath(subPath);
                vehicleList.add(vehicle);
            }
            return vehicleList;
        }
        return null;
    }

    //行人的数据封装
    @SuppressWarnings("unchecked")
    public static List<Person> getPersonData(List<JSONObject> imageResults,String imagePath){
        ArrayList <Person> personList = new ArrayList <>();
        for (JSONObject jsonObject:imageResults){
            List<JSONObject> bikes = (List <JSONObject>) jsonObject.get("Bikes");
            for(JSONObject js:bikes){
                com.hzgc.seemmo.bean.personbean.Recognize recognize_object = new com.hzgc.seemmo.bean.personbean.Recognize();
                Person person_object = new Person();
                JSONObject car_detect = (JSONObject) js.get("Detect");
                int car_code = (int) car_detect.get("Code");
                JSONArray car_rect = null;
                if (0 == car_code) {
                    int car_type = (int) js.get("Type");
                    recognize_object.setCar_type(car_type);
                    JSONObject car_body = (JSONObject) car_detect.get("Body");
                    car_rect = (JSONArray) car_body.get("Rect");
                }
                List<JSONObject> persons = (List <JSONObject>) js.get("Persons");
                if (persons.size() > 0 && null != persons){
                for (JSONObject person:persons) {
                    JSONArray person_rect = null;
                    JSONObject detect = (JSONObject) person.get("Detect");
                    if (null != detect) {
                    int person_code = (int) detect.get("Code");
                    if (0 == person_code) {
                        JSONObject body = (JSONObject) detect.get("Body");
                        person_rect = (JSONArray) body.get("Rect");
                    }
                }
                    JSONObject recognize = (JSONObject) person.get("Recognize");

                    JSONObject shoulderBag = (JSONObject) recognize.get("ShoulderBag");
                    if (null != shoulderBag){
                        int code = (int) shoulderBag.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) shoulderBag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setShoulderBag_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject bottomType = (JSONObject) recognize.get("BottomType");
                    if (null != bottomType){
                        int code = (int) bottomType.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bottomType.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setBottomType_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject umbrella = (JSONObject) recognize.get("Umbrella");
                    if (null != umbrella){
                        int code = (int) umbrella.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) umbrella.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setUmbrella_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject orientation = (JSONObject) recognize.get("Orientation");
                    if (null != orientation){
                        int code = (int) orientation.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) orientation.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setOrientation_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject messengerBag = (JSONObject) recognize.get("MessengerBag");
                    if (null != messengerBag){
                        int code = (int) messengerBag.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) messengerBag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setMessengerBag_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject upperType = (JSONObject) recognize.get("UpperType");
                    if (null != upperType){
                        int code = (int) upperType.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) upperType.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setUpperType_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject age = (JSONObject) recognize.get("Age");
                    if (null != age){
                        int code = (int) age.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) age.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setAge_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject upperColor = (JSONObject) recognize.get("UpperColor");
                    if (null != upperColor){
                        int code = (int) upperColor.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) upperColor.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setUpperColor_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject sex = (JSONObject) recognize.get("Sex");
                    if (null != sex){
                        int code = (int) sex.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) sex.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setSex_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject hair = (JSONObject) recognize.get("Hair");
                    if (null != hair){
                        int code = (int) hair.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) hair.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setHair_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject bag = (JSONObject) recognize.get("Bag");
                    if (null != bag){
                        int code = (int) bag.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setBag_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject knapsack = (JSONObject) recognize.get("Knapsack");
                    if (null != knapsack){
                        int code = (int) knapsack.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) knapsack.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setKnapsack_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject baby = (JSONObject) recognize.get("Baby");
                    if (null != baby){
                        int code = (int) baby.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) baby.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setBaby_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject hat = (JSONObject) recognize.get("Hat");
                    if (null != hat){
                        int code = (int) hat.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) hat.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setHat_code((String) jsonObject1.get("Code"));
                        }
                    }
                    JSONObject bottomColor = (JSONObject) recognize.get("BottomColor");
                    if (null != bottomColor){
                        int code = (int) bottomColor.get("Code");
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bottomColor.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            recognize_object.setBottomColor_code((String) jsonObject1.get("Code"));
                        }
                    }
                    //截取车和人的照片的图片
//                    CutImageUtil cutImageUtil = new CutImageUtil((int)rect.get(0), (int)rect.get(0), (int)rect.get(0), (int)rect.get(0));
                    //图片信息
//                    recognize_object.setCar_data();
                    person_object.setRecognize(recognize_object);
                    System.out.println(person_object);
                    personList.add(person_object);
                }
                }
            }
            return personList;
        }
        return null;
    }

    public static void main(String[] args) {
        String result = ImageToData.getImageResult("http://172.18.18.139:8000/?cmd=recogPic", "C:\\Users\\g10255\\Desktop\\carandpeople\\123456.jpg");
        new ImageToData().getData(result,"C:\\Users\\g10255\\Desktop\\carandpeople\\123456.jpg","3");
    }
}
