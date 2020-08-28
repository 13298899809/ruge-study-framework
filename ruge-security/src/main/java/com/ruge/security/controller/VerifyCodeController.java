package com.ruge.security.controller;

import com.ruge.security.tool.VerifyCodeTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName VerifyCodeController
 * @date 2020.07.03 10:15
 */
@RestController
public class VerifyCodeController {
        @GetMapping("/vercode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedImage image = VerifyCodeTool.getImage();
        String text = VerifyCodeTool.getText();
        HttpSession session = req.getSession();
        session.setAttribute("index_code", text);
        VerifyCodeTool.output(image, resp.getOutputStream());
    }
}
