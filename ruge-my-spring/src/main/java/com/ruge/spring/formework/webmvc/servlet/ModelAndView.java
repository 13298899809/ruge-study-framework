package com.ruge.spring.formework.webmvc.servlet;

import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:06
 */
public class ModelAndView {
    private String viewName;
    private Map<String,?> model;

    public ModelAndView(String viewName) { this.viewName = viewName; }

    public ModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

//    public void setViewName(String viewName) {
//        this.viewName = viewName;
//    }

    public Map<String, ?> getModel() {
        return model;
    }

//    public void setModel(Map<String, ?> model) {
//        this.model = model;
//    }
}
