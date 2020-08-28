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
public class MainServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();

        jaxWsServerFactoryBean.setAddress("http://127.0.0.1:8080/");
        jaxWsServerFactoryBean.setServiceClass(TestApiServiceImpl.class);
        Server server = jaxWsServerFactoryBean.create();
        server.start();
    }
}
