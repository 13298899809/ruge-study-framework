package com.ruge.webservice;

import com.ruge.webservice.domain.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 实体类与xml转换
 * @date 2020/8/31 23:02
 */
public class JAXBTest {
    public static void myMarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");

        Person person = new Person();
        person.setAge(12);
        person.setName("张三");

        marshaller.marshal(person,System.out);
        marshaller.marshal(person,new File("C:\\Users\\Administrator\\Desktop\\ruge_edu\\a.txt"));
    }

    public static void myUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(new File("C:\\Users\\Administrator\\Desktop\\ruge_edu\\a.txt"));
        System.out.println(unmarshal);
    }

    public static void main(String[] args) throws JAXBException {
//        myMarshaller();
    myUnmarshaller();
    }
}
