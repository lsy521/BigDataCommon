package com.hzgc.common.personattribute.service;

import com.hzgc.common.personattribute.bean.PersonAttribute;
import com.hzgc.common.personattribute.bean.PersonAttributeValue;
import com.hzgc.common.personattribute.bean.PersonLogistic;
import com.hzgc.common.personattribute.pubclass.ReadPersonInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 *行人属性查询
 */
public class PersonAttributeService {
    public List<PersonAttribute> getPersonAttribute(){
        List<PersonAttribute> personAttributes = new ArrayList<>();
        ReadPersonInfo readPersonInfo = new ReadPersonInfo();
        Map<String,Map<String,String>> personMap = readPersonInfo.getPersonMap();

        //行人年龄
        Map<String ,String> ageMap = personMap.get("age");
        PersonAttribute personAge =new PersonAttribute();
        personAge.setIdentify("age");
        personAge.setDesc("行人的年龄");
        personAge.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personAgeValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : ageMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personAgeValues.add(personAttributeValue);
        }
        personAge.setValues(personAgeValues);
        personAttributes.add(personAge);

        //小孩类型
        Map<String ,String> babyMap = personMap.get("baby");
        PersonAttribute personBaby = new PersonAttribute();
        personBaby.setIdentify("baby");
        personBaby.setDesc("抱小孩类型");
        personBaby.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personBabyValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : babyMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personBabyValues.add(personAttributeValue);
        }
        personBaby.setValues(personBabyValues);
        personAttributes.add(personBaby);

        //拎东西
        Map<String ,String> bagMap = personMap.get("bag");
        PersonAttribute personBag = new PersonAttribute();
        personBag.setIdentify("bag");
        personBag.setDesc("拎东西");
        personBag.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personBagValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : bagMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personBagValues.add(personAttributeValue);
        }
        personBag.setValues(personBagValues);
        personAttributes.add(personBag);

        //下衣颜色
        Map<String ,String> bottomColorMap = personMap.get("bottomColor");
        PersonAttribute personBottomColor = new PersonAttribute();
        personBottomColor.setIdentify("bottomColor");
        personBottomColor.setDesc("下衣颜色");
        personBottomColor.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personBottomColorValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : bottomColorMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personBottomColorValues.add(personAttributeValue);
        }
        personBottomColor.setValues(personBottomColorValues);
        personAttributes.add(personBottomColor);

        //下衣类型
        Map<String ,String> bottomTypeMap = personMap.get("bottomType");
        PersonAttribute personBottomType = new PersonAttribute();
        personBottomType.setIdentify("bottomType");
        personBottomType.setDesc("下衣类型");
        personBottomType.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personBottomTypeValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : bottomTypeMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personBottomTypeValues.add(personAttributeValue);
        }
        personBottomType.setValues(personBottomTypeValues);
        personAttributes.add(personBottomType);

        //帽子类型
        Map<String ,String> hatMap = personMap.get("hat");
        PersonAttribute personHat = new PersonAttribute();
        personHat.setIdentify("hat");
        personHat.setDesc("帽子");
        personHat.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personHatValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : hatMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personHatValues.add(personAttributeValue);
        }
        personHat.setValues(personHatValues);
        personAttributes.add(personHat);

        //头发类型
        Map<String ,String> hairMap = personMap.get("hair");
        PersonAttribute personHair = new PersonAttribute();
        personHair.setIdentify("hair");
        personHair.setDesc("头发");
        personHair.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personHairValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : hairMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personHairValues.add(personAttributeValue);
        }
        personHair.setValues(personHairValues);
        personAttributes.add(personHair);

        //背包类型
        Map<String ,String> knapsackMap = personMap.get("knapsack");
        PersonAttribute personKnapsack = new PersonAttribute();
        personKnapsack.setIdentify("knapsack");
        personKnapsack.setDesc("背包类型");
        personKnapsack.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personKnapsackValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : knapsackMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personKnapsackValues.add(personAttributeValue);
        }
        personKnapsack.setValues(personKnapsackValues);
        personAttributes.add(personKnapsack);

        //背包方式
        Map<String ,String> messengerBag = personMap.get("messengerBag");
        PersonAttribute personMessengerBag = new PersonAttribute();
        personMessengerBag.setIdentify("messengerBag");
        personMessengerBag.setDesc("背包方式");
        personMessengerBag.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personMessenegerBagValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : messengerBag.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personMessenegerBagValues.add(personAttributeValue);
        }
        personMessengerBag.setValues(personMessenegerBagValues);
        personAttributes.add(personMessengerBag);

        //行人方向
        Map<String ,String> orientation = personMap.get("orientation");
        PersonAttribute personOrientationBag = new PersonAttribute();
        personOrientationBag.setIdentify("orientation");
        personOrientationBag.setDesc("行人方向");
        personOrientationBag.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personOrientationValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : orientation.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personOrientationValues.add(personAttributeValue);
        }
        personOrientationBag.setValues(personOrientationValues);
        personAttributes.add(personOrientationBag);

        //性别
        Map<String ,String> sex = personMap.get("sex");
        PersonAttribute personSex = new PersonAttribute();
        personSex.setIdentify("sex");
        personSex.setDesc("性别");
        personSex.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personSexValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : sex.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personSexValues.add(personAttributeValue);
        }
        personSex.setValues(personSexValues);
        personAttributes.add(personSex);

        //肩上的包
        Map<String ,String> shoudlerBag = personMap.get("shoudlerBag");
        PersonAttribute personShoudlerBag= new PersonAttribute();
        personShoudlerBag.setIdentify("shoudlerBag");
        personShoudlerBag.setDesc("肩上的包");
        personShoudlerBag.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personShoudlerBagValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : shoudlerBag.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personShoudlerBagValues.add(personAttributeValue);
        }
        personShoudlerBag.setValues(personShoudlerBagValues);
        personAttributes.add(personShoudlerBag);

        //雨伞
        Map<String ,String> umbrella = personMap.get("umbrella");
        PersonAttribute personUmbrella= new PersonAttribute();
        personUmbrella.setIdentify("umbrella");
        personUmbrella.setDesc("雨伞");
        personUmbrella.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personUmbrellaValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : umbrella.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personUmbrellaValues.add(personAttributeValue);
        }
        personUmbrella.setValues(personUmbrellaValues);
        personAttributes.add(personUmbrella);

        //上衣颜色
        Map<String ,String> upperColor = personMap.get("upperColor");
        PersonAttribute personUpperColor= new PersonAttribute();
        personUpperColor.setIdentify("upperColor");
        personUpperColor.setDesc("上衣颜色");
        personUpperColor.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personUpperColorValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : upperColor.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personUpperColorValues.add(personAttributeValue);
        }
        personUpperColor.setValues(personUpperColorValues);
        personAttributes.add(personUpperColor);

        //上衣类型
        Map<String ,String> upperType = personMap.get("upperType");
        PersonAttribute personUpperType= new PersonAttribute();
        personUpperType.setIdentify("upperType");
        personUpperType.setDesc("上衣类型");
        personUpperType.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personUpperTypeValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : upperType.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personUpperTypeValues.add(personAttributeValue);
        }
        personUpperType.setValues(personUpperTypeValues);
        personAttributes.add(personUpperType);

        //车辆类型
        Map<String ,String> type = personMap.get("type");
        PersonAttribute personCarType= new PersonAttribute();
        personCarType.setIdentify("type");
        personCarType.setDesc("车辆类型");
        personCarType.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personCarTypeValues = new ArrayList<>();
        for (Map.Entry<String,String> entry : type.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            personAttributeValue.setDesc(entry.getValue());
            personAttributeValue.setCode(entry.getKey());
            personCarTypeValues.add(personAttributeValue);
        }
        personCarType.setValues(personCarTypeValues);
        personAttributes.add(personCarType);





        return personAttributes;
    }
}
