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
        List<PersonAttribute> personAttributes = new ArrayList<PersonAttribute>();
        ReadPersonInfo readPersonInfo = new ReadPersonInfo();
        Map<String,Map<String,String>> personMap = readPersonInfo.getPersonMap();

//        //行人年龄
//        Map<String ,String> ageMap = personMap.get("age");
//        PersonAttribute personAge =new PersonAttribute();
//        personAge.setIdentify("age");
//        personAge.setDesc("行人的年龄");
//        personAge.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personAgeValues = new ArrayList<PersonAttributeValue>();
//
//        for (Map.Entry<String,String> entry : ageMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = ageMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personAgeValues.add(personAttributeValue);
//        }
//        personAge.setValues(personAgeValues);
//        personAttributes.add(personAge);

        //小孩类型
//        Map<String ,String> babyMap = personMap.get("baby");
//        PersonAttribute personBaby = new PersonAttribute();
//        personBaby.setIdentify("baby");
//        personBaby.setDesc("抱小孩类型");
//        personBaby.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personBabyValues = new ArrayList<PersonAttributeValue>();
//        for (Map.Entry<String,String> entry : babyMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = babyMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personBabyValues.add(personAttributeValue);
//        }
//        personBaby.setValues(personBabyValues);
//        personAttributes.add(personBaby);

        //拎东西
//        Map<String ,String> bagMap = personMap.get("bag");
//        PersonAttribute personBag = new PersonAttribute();
//        personBag.setIdentify("bag");
//        personBag.setDesc("拎东西");
//        personBag.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personBagValues = new ArrayList<PersonAttributeValue>();
//        for (Map.Entry<String,String> entry : bagMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = bagMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personBagValues.add(personAttributeValue);
//        }
//        personBag.setValues(personBagValues);
//        personAttributes.add(personBag);

        //下衣颜色
//        Map<String ,String> bottomColorMap = personMap.get("bottomColor");
//        PersonAttribute personBottomColor = new PersonAttribute();
//        personBottomColor.setIdentify("bottomColor");
//        personBottomColor.setDesc("下衣颜色");
//        personBottomColor.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personBottomColorValues = new ArrayList<PersonAttributeValue>();
//        for (Map.Entry<String,String> entry : bottomColorMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = bottomColorMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personBottomColorValues.add(personAttributeValue);
//        }
//        personBottomColor.setValues(personBottomColorValues);
//        personAttributes.add(personBottomColor);

        //下衣类型
//        Map<String ,String> bottomTypeMap = personMap.get("bottomType");
//        PersonAttribute personBottomType = new PersonAttribute();
//        personBottomType.setIdentify("bottomType");
//        personBottomType.setDesc("下衣类型");
//        personBottomType.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personBottomTypeValues = new ArrayList<PersonAttributeValue>();
//        for (Map.Entry<String,String> entry : bottomTypeMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = bottomTypeMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personBottomTypeValues.add(personAttributeValue);
//        }
//        personBottomType.setValues(personBottomTypeValues);
//        personAttributes.add(personBottomType);

        //帽子类型
//        Map<String ,String> hatMap = personMap.get("hat");
//        PersonAttribute personHat = new PersonAttribute();
//        personHat.setIdentify("hat");
//        personHat.setDesc("帽子");
//        personHat.setPersonLogistic(PersonLogistic.AND);
//        List<PersonAttributeValue> personHatValues = new ArrayList<PersonAttributeValue>();
//        for (Map.Entry<String,String> entry : hatMap.entrySet()){
//            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
//            String desc = hatMap.get(entry.getValue());
//            personAttributeValue.setDesc(desc);
//            personAttributeValue.setCode(entry.getKey());
//            personHatValues.add(personAttributeValue);
//        }
//        personHat.setValues(personHatValues);
//        personAttributes.add(personHat);

        //头发类型
        Map<String ,String> hatMap = personMap.get("hair");
        PersonAttribute personHat = new PersonAttribute();
        personHat.setIdentify("hair");
        personHat.setDesc("头发");
        personHat.setPersonLogistic(PersonLogistic.AND);
        List<PersonAttributeValue> personHatValues = new ArrayList<PersonAttributeValue>();
        for (Map.Entry<String,String> entry : hatMap.entrySet()){
            PersonAttributeValue personAttributeValue = new PersonAttributeValue();
            String desc = hatMap.get(entry.getValue());
            personAttributeValue.setDesc(desc);
            personAttributeValue.setCode(entry.getKey());
            personHatValues.add(personAttributeValue);
        }
        personHat.setValues(personHatValues);
        personAttributes.add(personHat);



        return personAttributes;
    }
}
