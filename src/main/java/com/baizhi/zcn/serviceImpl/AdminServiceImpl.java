package com.baizhi.zcn.serviceImpl;

import com.baizhi.zcn.dao.AdminMapper;
import com.baizhi.zcn.entity.Admin;
import com.baizhi.zcn.entity.AdminExample;
import com.baizhi.zcn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminDao;

    @Resource
    AdminExample adminExample;

    @Override
    public HashMap<String, Object> login(String enCode, String username, String password, HttpSession session) {


        HashMap<String, Object> map = new HashMap<>();
        //获取验证码
        String imageCode = (String) session.getAttribute("ImageCode");

        //判断验证码是否一致
        if(imageCode.equals(enCode)){

            System.out.println("username="+username);
            //设置查询条件
            adminExample.createCriteria().andUsernameEqualTo(username);

            //根据查询条件  按照根据管理员用户名查询管理员  返回管理员对象
            Admin admin = adminDao.selectOneByExample(adminExample);
            System.out.println(admin);
            //判断用户
            if(admin!=null){
                //判断密码
                if(admin.getPassword().equals(password)){
                    //存储用户标记
                    session.setAttribute("admin",admin);
                    map.put("success","200");
                    map.put("message","登录成功");
                }else{
                    map.put("success","400");
                    map.put("message","密码错误");
                }
            }else{
                map.put("success","400");
                map.put("message","该用户不存在");
            }
        }else{
            map.put("success","400");
            map.put("message","验证码不正确");
        }
        return map;
    }
}
