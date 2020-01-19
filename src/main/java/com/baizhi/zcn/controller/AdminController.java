package com.baizhi.zcn.controller;

import com.baizhi.zcn.service.AdminService;
import com.baizhi.zcn.util.ImageCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("getImageCode")
    public void getImageCode(HttpSession session, HttpServletResponse response){

        //1.获取验证码随机字符
        String code = ImageCodeUtil.getSecurityCode();
        System.out.println("验证码："+code);
        //2.将随机字符存入作用域
        session.setAttribute("ImageCode",code);
        //3.将验证码字符生成验证码图片
        BufferedImage image = ImageCodeUtil.createImage(code);
        //4.设置相应的格式
        response.setContentType("image/png");
        system.out.println("git传输测试");
        try {
            //5.将验证码响应到前台页面
            ImageIO.write(image,"png",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(String enCode,String username,String password,HttpSession session){

        System.out.println(enCode+"=="+username+"=="+password);

        HashMap<String, Object> map = adminService.login(enCode, username, password, session);

        return map;
    }
}
