package com.ruge.webservice.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Person
 * @date 2020.08.28 14:07
 */
@Getter
@Setter
@ToString
@XmlRootElement
public class Person {
    private Integer id;
    private String name;
    private String niceName;
    private Integer age;
    private Double height;

    public Person() {
    }
}
