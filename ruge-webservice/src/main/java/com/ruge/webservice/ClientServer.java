package com.ruge.webservice;


import com.ruge.webservice.service.TestApiServiceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName MainServer
 * @date 2020.08.28 14:18
 */
public class ClientServer {
    public static void main(String[] args) {
        TestApiServiceImpl testApiService = new TestApiServiceImpl();
        testApiService.insertPersonInfo("张三");
    }
}
