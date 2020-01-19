package com.baizhi.zcn.service;

import com.baizhi.zcn.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface BannerService  {

    String add(Banner banner);

    void bannerUpload(MultipartFile srcImg, String id, HttpServletRequest request);
}
