package com.ruge.spring.formework.webmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:06
 */
public class View {
    public final String DEFULAT_CONTENT_TYPE = "text/html;charset=utf-8";
    private Pattern pattern = Pattern.compile("￥\\{[^\\}]+\\}", Pattern.CASE_INSENSITIVE);

    private File viewFile;

    public View(File viewFile) {
        this.viewFile = viewFile;
    }

    public void render(Map<String, ?> model,
                       HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer sb = new StringBuffer();

        RandomAccessFile ra = new RandomAccessFile(this.viewFile, "r");

        String line = null;
        while (null != (line = ra.readLine())) {
            line = new String(line.getBytes("ISO-8859-1"), "utf-8");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String paramName = matcher.group();
                paramName = paramName.replaceAll("￥\\{|\\}", "");
                Object paramValue = model.get(paramName);
                if (null == paramValue) {
                    continue;
                }
                line = matcher.replaceFirst(makeStringForRegExp(paramValue.toString()));
                matcher = pattern.matcher(line);
            }
            sb.append(line);
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType(DEFULAT_CONTENT_TYPE);
        response.getWriter().write(sb.toString());
    }


    /**
     * 处理特殊字符
     *
     * @param str 字符串
     * @return 处理特殊字符后的字符串
     */
    public static String makeStringForRegExp(String str) {
        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }
}
