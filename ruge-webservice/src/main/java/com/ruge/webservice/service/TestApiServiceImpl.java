package com.ruge.webservice.service;

import com.alibaba.fastjson.JSONArray;
import com.ruge.webservice.domain.Person;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TestApiServiceImpl
 * @date 2020.08.28 14:08
 */
//@Component
//@WebService(name = "testApiService",
//        targetNamespace = "http://service.mywebservice.sunzy.com",
//        endpointInterface = "com.ruge.webservice.service.TestApiService",
//        portName = "10000")
public class TestApiServiceImpl implements TestApiService {
    @Override
    public Person insertPersonInfo(String personName) {
        System.out.println("服务端接口到了请求:person=" + personName);
        List<Person> list = JSONArray.parseArray(personName, Person.class);
        //TODO 逻辑处理
        return list.get(0);
    }
}
