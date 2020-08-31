package com.ruge.webservice.service;

import com.ruge.webservice.domain.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
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
     * <xs:complexType name="insertPersonInfo">
     * <xs:sequence>
     * <xs:element minOccurs="0" name="arg0" type="xs:string"/>
     * </xs:sequence>
     * </xs:complexType>
     *
     *
     * <xs:complexType name="insertPersonInfoResponse">
     * <xs:sequence>
     * <xs:element minOccurs="0" name="return" type="tns:person"/>
     * </xs:sequence>
     * </xs:complexType>
     *
     * @param personName
     * @return
     */
    @WebMethod
    @WebResult(name = "insertResult")
    Person insertPersonInfo(@WebParam(name = "personName") String personName);
}
