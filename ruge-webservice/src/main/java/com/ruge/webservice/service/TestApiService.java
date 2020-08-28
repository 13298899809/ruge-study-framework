package com.ruge.webservice.service;

import com.ruge.webservice.domain.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TestApiService
 * @date 2020.08.28 14:08
 */
@WebService
public interface TestApiService {

    /**
     * 解析出的地址  http://localhost:8080/ws/testApiService?wsdl
     *
     * @param person
     * @return
     */
//    @WebMethod
    Person insertPersonInfo(String person);
}
