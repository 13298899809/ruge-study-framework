package com.ruge.spring5.converter;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class MyConverter implements Converter<String, Date> {

    private String pattern;

    @Override
    public Date convert(String s) {
        System.out.println(s);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
