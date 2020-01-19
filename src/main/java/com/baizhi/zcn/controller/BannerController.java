package com.baizhi.zcn.controller;

import com.baizhi.zcn.entity.Banner;
import com.baizhi.zcn.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("edit")
    public String edit(Banner banner,String oper){

        String id=null;

        //添加
        if(oper.equals("add")){

            System.out.println("controller: banner== "+banner);
             id= bannerService.add(banner);
        }
        //修改
        if(oper.equals("edit")){

        }

        //删除
        if(oper.equals("del")){

        }
        return id;
    }

    @RequestMapping("uploadBanner")
    public void uploadBanner(MultipartFile srcImg, String id, HttpServletRequest request){

        bannerService.bannerUpload(srcImg,id,request);

    }

}
