package com.baizhi.zcn.serviceImpl;

import com.baizhi.zcn.dao.BannerMapper;
import com.baizhi.zcn.entity.Banner;
import com.baizhi.zcn.entity.BannerExample;
import com.baizhi.zcn.service.BannerService;
import com.baizhi.zcn.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Resource
    BannerMapper bannerMapper;

    @Resource
    BannerExample bannerExample;

    @Override
    public String add(Banner banner) {

        String uuid = UUIDUtil.getUUID();
        banner.setId(uuid);
        banner.setStatus("1");
        banner.setUploadTime(new Date());

        System.out.println("==banner: "+banner);
        bannerMapper.insert(banner);

        return uuid;
    }

    @Override
    public void bannerUpload(MultipartFile srcImg, String id, HttpServletRequest request) {
        //1.根据相对路径获取绝对路径
        String realPath = request.getServletContext().getRealPath("/upload/photo");

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        //2.获取文件名
        String filename = srcImg.getOriginalFilename();
        //从新给图片命名
        String newName = new Date().getTime()+"-"+filename;

        //3.文件上传
        try {
            srcImg.transferTo(new File(realPath,newName));


            //修改轮播图信息
            Banner banner = new Banner();
            banner.setId(id);
            banner.setSrcImg(newName);

            System.out.println(banner);
            //调用修改方法

            bannerMapper.updateByPrimaryKeySelective(banner);
            //bannerExample.createCriteria().andIdEqualTo(banner.getId());
            bannerMapper.updateByExampleSelective(banner,bannerExample);
            //bannerMapper.update(banner);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
