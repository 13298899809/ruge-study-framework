package com.ruge.spring.formework.webmvc.servlet;

import java.io.File;
import java.util.Locale;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:07
 */
public class ViewResolver {
    private final String DEFAULT_TEMPLATE_SUFFX = ".html";

    private File templateRootDir;
//    private String viewName;

    public ViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (null == viewName || "".equals(viewName.trim())) {
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFX);
        File templateFile = new File((templateRootDir.getPath() + "/" + viewName).replaceAll("/+", "/"));
        return new View(templateFile);
    }

//    public String getViewName() {
//        return viewName;
//    }
}
