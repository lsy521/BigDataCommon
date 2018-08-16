package com.hzgc.seemmo.service;

import com.alibaba.fastjson.JSON;
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
                JSONObject recognize = (JSONObject) js1.get("Recognize");
                int type1 = (int) js1.get("Type");
                JSONObject detect = (JSONObject) js1.get("Detect");
                JSONObject car = (JSONObject) detect.get("Body");
                JSONArray rect = (JSONArray) car.get("Rect");
                Recognize recognize_object = new Recognize();
                JSONObject plate = (JSONObject) recognize.get("Plate");
                if (null != plate) {
                    int code = (int) plate.get("Code");
                    Plate plate_object = new Plate();
                    if (0 == code){
                        JSONObject color = (JSONObject) plate.get("Color");
                        plate_object.setColorCode((String)color.get("Code"));
                        plate_object.setColorDesc((String) color.get("Name"));
                        plate_object.setDestain((boolean) plate.get("Destain"));
                        plate_object.setFlag((int) plate.get("Flag"));
                        plate_object.setLicence((String) plate.get("Licence"));
                        plate_object.setSchelter((boolean) plate.get("Shelter"));
                    }
                    recognize_object.setPlate(plate_object);
                }
                JSONObject crash = (JSONObject) recognize.get("Crash");
                if (null != crash){
                    int code = (int) crash.get("Code");
                    Crash crash_object = new Crash();
                    if (0 == code){
                        crash_object.setHasCrash((boolean) crash.get("HasCrash"));
                    }
                    recognize_object.setCrash(crash_object);
                }
                JSONObject danger = (JSONObject) recognize.get("Danger");
                if (null != danger){
                    int code = (int) danger.get("Code");
                    Danger danger_object = new Danger();
                    if (0 == code){
                        danger_object.setHasDanger((boolean) danger.get("HasDanger"));
                    }
                    recognize_object.setDanger(danger_object);
                }
                JSONObject color = (JSONObject) recognize.get("Color");
                if (null != color){
                    int code = (int) color.get("Code");
                    Color color_object = new Color();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) color.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        color_object.setCode((String) jsonObject1.get("Code"));
                        color_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setColor(color_object);
                }
                JSONObject brand = (JSONObject) recognize.get("Brand");
                if (null != brand){
                    int code = (int) brand.get("Code");
                    Brand brand_object = new Brand();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) brand.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        brand_object.setCode((String) jsonObject1.get("Code"));
                        brand_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setBrand(brand_object);
                }
                JSONObject sunroof = (JSONObject) recognize.get("Sunroof");
                if (null != sunroof){
                    int code = (int) sunroof.get("Code");
                    Sunroof sunroof_object = new Sunroof();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) sunroof.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        sunroof_object.setCode((String) jsonObject1.get("Code"));
                        sunroof_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setSunroof(sunroof_object);
                }
                JSONObject feature = (JSONObject) recognize.get("Feature");
                if (null != feature){
                    int code = (int) feature.get("Code");
                    Feature feature_object = new Feature();
                    if (0 == code){
                        feature_object.setFeature((String) feature.get("Feature"));
                    }
                    recognize_object.setFeature(feature_object);
                }
                JSONObject call = (JSONObject) recognize.get("Call");
                if (null != call){
                    int code = (int) call.get("Code");
                    Call call_object = new Call();
                    if (0 == code){
                        call_object.setHasCall((boolean) call.get("HasCall"));
                    }
                    recognize_object.setCall(call_object);
                }
                JSONObject marker = (JSONObject) recognize.get("Marker");
                if (null != marker){
                    int code = (int) marker.get("Code");
                    Marker marker_object = new Marker();
                    if (0 == code){
                        //小物品检测没有处理
                    }
                    recognize_object.setMarker(marker_object);
                }
                JSONObject mistake = (JSONObject) recognize.get("Mistake");
                if (null != mistake){
                    int code = (int) mistake.get("Code");
                    Mistake mistake_object = new Mistake();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) mistake.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        mistake_object.setCode((String) jsonObject1.get("Code"));
                        mistake_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setMistake(mistake_object);
                }
                JSONObject type = (JSONObject) recognize.get("Type");
                if (null != type){
                    int code = (int) type.get("Code");
                    Type type_object = new Type();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) type.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        type_object.setCode((String) jsonObject1.get("Code"));
                        type_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setType(type_object);
                }
                JSONObject rack = (JSONObject) recognize.get("Rack");
                if (null != rack){
                    int code = (int) rack.get("Code");
                    Rack rack_object = new Rack();
                    if (0 == code){
                        List<JSONObject> topList = (List <JSONObject>) rack.get("TopList");
                        JSONObject jsonObject1 = topList.get(0);
                        rack_object.setCode((String) jsonObject1.get("Code"));
                        rack_object.setName((String) jsonObject1.get("Name"));
                    }
                    recognize_object.setRack(rack_object);
                }
                JSONObject spareTire = (JSONObject) recognize.get("SpareTire");
                if (null != spareTire){
                    int code = (int) spareTire.get("Code");
                    SpareTire spareTire_object = new SpareTire();
                    if (0 == code){
                        spareTire_object.setHasSpareTire((boolean) spareTire.get("HasSpareTire"));
                    }
                    recognize_object.setSpareTire(spareTire_object);
                }
                JSONObject belt = (JSONObject) recognize.get("Belt");
                if (null != belt){
                    int code = (int) belt.get("Code");
                    Belt belt_object = new Belt();
                    if (0 == code){
                        JSONObject coDriver = (JSONObject) belt.get("CoDriver");
                        belt_object.setCoDriver_noBelt((boolean) coDriver.get("NoBelt"));
                        JSONObject mainDriver = (JSONObject) belt.get("MainDriver");
                        belt_object.setCoDriver_noBelt((boolean) mainDriver.get("NoBelt"));
                    }
                    recognize_object.setBelt(belt_object);
                }
                vehicle.setRecognize(recognize_object);
                vehicle.setType(type1);
                System.out.println(vehicle);
                //截图车的图片
                CutImageUtil cutImageUtil = new CutImageUtil((int)rect.get(0), (int)rect.get(1), (int)rect.get(2), (int)rect.get(3));
                cutImageUtil.setSrcpath(imagePath);
                String subPath = "";
                cutImageUtil.setSubpath(subPath);
                vehicle.setCarPath(subPath);
                vehicleList.add(vehicle);
            }
            return vehicleList;
        }
        return null;
    }

    //行人的数据封装
    @SuppressWarnings("unchecked")
    public static List<Person> getPersonData(List<JSONObject> imageResults,String imagePath){
        for (JSONObject jsonObject:imageResults){
            List<JSONObject> bikes = (List <JSONObject>) jsonObject.get("Bikes");
            for(JSONObject js:bikes){
                List<JSONObject> persons = (List <JSONObject>) js.get("Persons");
                ArrayList <Person> personList = new ArrayList <>();
                if (persons.size() > 0 && null != persons){
                for (JSONObject person:persons) {
                    JSONArray rect = null;
                    Person person_object = new Person();
                    com.hzgc.seemmo.bean.personbean.Recognize recognize_object = new com.hzgc.seemmo.bean.personbean.Recognize();
                    JSONObject detect = (JSONObject) person.get("Detect");
                    if (null != detect) {
                    int code = (int) detect.get("Code");
                    if (0 == code) {
                        JSONObject body = (JSONObject) detect.get("Body");
                        rect = (JSONArray) body.get("Rect");
                    }
                }
                    JSONObject recognize = (JSONObject) person.get("Recognize");
                    JSONObject trolleyCase = (JSONObject) recognize.get("TrolleyCase");
                    if (null != trolleyCase){
                        int code = (int) trolleyCase.get("Code");
                        TrolleyCase trolleyCase_object = new TrolleyCase();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) trolleyCase.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            trolleyCase_object.setCode((String) jsonObject1.get("Code"));
                            trolleyCase_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setTrolleyCase(trolleyCase_object);
                    }
                    JSONObject shoulderBag = (JSONObject) recognize.get("ShoulderBag");
                    if (null != shoulderBag){
                        int code = (int) shoulderBag.get("Code");
                        ShoulderBag shoulderBag_object = new ShoulderBag();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) shoulderBag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            shoulderBag_object.setCode((String) jsonObject1.get("Code"));
                            shoulderBag_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setShoulderBag(shoulderBag_object);
                    }
                    JSONObject bottomType = (JSONObject) recognize.get("BottomType");
                    if (null != bottomType){
                        int code = (int) bottomType.get("Code");
                        BottomType bottomType_object = new BottomType();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bottomType.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            bottomType_object.setCode((String) jsonObject1.get("Code"));
                            bottomType_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setBottomType(bottomType_object);
                    }
                    JSONObject umbrella = (JSONObject) recognize.get("Umbrella");
                    if (null != umbrella){
                        int code = (int) umbrella.get("Code");
                        Umbrella umbrella_object = new Umbrella();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) umbrella.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            umbrella_object.setCode((String) jsonObject1.get("Code"));
                            umbrella_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setUmbrella(umbrella_object);
                    }
                    JSONObject orientation = (JSONObject) recognize.get("Orientation");
                    if (null != orientation){
                        int code = (int) orientation.get("Code");
                        Orientation orientation_object = new Orientation();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) orientation.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            orientation_object.setCode((String) jsonObject1.get("Code"));
                            orientation_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setOrientation(orientation_object);
                    }
                    JSONObject messengerBag = (JSONObject) recognize.get("MessengerBag");
                    if (null != messengerBag){
                        int code = (int) messengerBag.get("Code");
                        MessengerBag messengerBag_object = new MessengerBag();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) messengerBag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            messengerBag_object.setCode((String) jsonObject1.get("Code"));
                            messengerBag_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setMessengerBag(messengerBag_object);
                    }
                    JSONObject upperType = (JSONObject) recognize.get("UpperType");
                    if (null != upperType){
                        int code = (int) upperType.get("Code");
                        UpperType upperType_object = new UpperType();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) upperType.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            upperType_object.setCode((String) jsonObject1.get("Code"));
                            upperType_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setUpperType(upperType_object);
                    }
                    JSONObject age = (JSONObject) recognize.get("Age");
                    if (null != age){
                        int code = (int) age.get("Code");
                        Age age_object = new Age();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) age.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            age_object.setCode((String) jsonObject1.get("Code"));
                            age_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setAge(age_object);
                    }
                    JSONObject upperColor = (JSONObject) recognize.get("UpperColor");
                    if (null != upperColor){
                        int code = (int) upperColor.get("Code");
                        UpperColor upperColor_object = new UpperColor();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) upperColor.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            upperColor_object.setCode((String) jsonObject1.get("Code"));
                            upperColor_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setUpperColor(upperColor_object);
                    }
                    JSONObject mask = (JSONObject) recognize.get("Mask");
                    if (null != mask){
                        int code = (int) mask.get("Code");
                        Mask mask_object = new Mask();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) mask.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            mask_object.setCode((String) jsonObject1.get("Code"));
                            mask_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setMask(mask_object);
                    }
                    JSONObject sex = (JSONObject) recognize.get("Sex");
                    if (null != sex){
                        int code = (int) sex.get("Code");
                        Sex sex_object = new Sex();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) sex.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            sex_object.setCode((String) jsonObject1.get("Code"));
                            sex_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setSex(sex_object);
                    }
                    JSONObject hair = (JSONObject) recognize.get("Hair");
                    if (null != hair){
                        int code = (int) hair.get("Code");
                        Hair hair_object = new Hair();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) hair.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            hair_object.setCode((String) jsonObject1.get("Code"));
                            hair_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setHair(hair_object);
                    }
                    JSONObject bag = (JSONObject) recognize.get("Bag");
                    if (null != bag){
                        int code = (int) bag.get("Code");
                        Bag bag_object = new Bag();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bag.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            bag_object.setCode((String) jsonObject1.get("Code"));
                            bag_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setBag(bag_object);
                    }
                    JSONObject knapsack = (JSONObject) recognize.get("Knapsack");
                    if (null != knapsack){
                        int code = (int) knapsack.get("Code");
                        Knapsack knapsack_object = new Knapsack();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) knapsack.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            knapsack_object.setCode((String) jsonObject1.get("Code"));
                            knapsack_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setKnapsack(knapsack_object);
                    }
                    JSONObject baby = (JSONObject) recognize.get("Baby");
                    if (null != baby){
                        int code = (int) baby.get("Code");
                        Baby baby_object = new Baby();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) baby.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            baby_object.setCode((String) jsonObject1.get("Code"));
                            baby_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setBaby(baby_object);
                    }
                    JSONObject upperTexture = (JSONObject) recognize.get("UpperTexture");
                    if (null != upperTexture){
                        int code = (int) upperTexture.get("Code");
                        UpperTexture upperTexture_object = new UpperTexture();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) upperTexture.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            upperTexture_object.setCode((String) jsonObject1.get("Code"));
                            upperTexture_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setUpperTexture(upperTexture_object);
                    }
                    JSONObject glasses = (JSONObject) recognize.get("Glasses");
                    if (null != glasses){
                        int code = (int) glasses.get("Code");
                        Glasses glasses_object = new Glasses();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) glasses.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            glasses_object.setCode((String) jsonObject1.get("Code"));
                            glasses_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setGlasses(glasses_object);
                    }
                    JSONObject hat = (JSONObject) recognize.get("Hat");
                    if (null != hat){
                        int code = (int) hat.get("Code");
                        Hat hat_object = new Hat();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) hat.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            hat_object.setCode((String) jsonObject1.get("Code"));
                            hat_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setHat(hat_object);
                    }
                    JSONObject bottomColor = (JSONObject) recognize.get("BottomColor");
                    if (null != bottomColor){
                        int code = (int) bottomColor.get("Code");
                        BottomColor bottomColor_object = new BottomColor();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) bottomColor.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            bottomColor_object.setCode((String) jsonObject1.get("Code"));
                            bottomColor_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setBottomColor(bottomColor_object);
                    }
                    JSONObject barrow = (JSONObject) recognize.get("Barrow");
                    if (null != barrow){
                        int code = (int) barrow.get("Code");
                        Barrow barrow_object = new Barrow();
                        if (0 == code){
                            List<JSONObject> topList = (List <JSONObject>) barrow.get("TopList");
                            JSONObject jsonObject1 = topList.get(0);
                            barrow_object.setCode((String) jsonObject1.get("Code"));
                            barrow_object.setName((String) jsonObject1.get("Name"));
                        }
                        recognize_object.setBarrow(barrow_object);
                    }
                    int type = (int) person.get("Type");
                    person_object.setType(type);
                    person_object.setRecognize(recognize_object);
                    //截取行人的图片
                    CutImageUtil cutImageUtil = new CutImageUtil((int)rect.get(0), (int)rect.get(0), (int)rect.get(0), (int)rect.get(0));
                    cutImageUtil.setSrcpath(imagePath);
                    String subPath = "";
                    cutImageUtil.setSubpath(subPath);
                    person_object.setPersonPath(subPath);
                    personList.add(person_object);
                }
                return personList;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String result = ImageToData.getImageResult("http://172.18.18.139:8000/?cmd=recogPic", "C:\\Users\\g10255\\Desktop\\carandpeople\\123456.jpg");
        new ImageToData().getData(result,"C:\\Users\\g10255\\Desktop\\carandpeople\\123456.jpg","0");
    }
}
