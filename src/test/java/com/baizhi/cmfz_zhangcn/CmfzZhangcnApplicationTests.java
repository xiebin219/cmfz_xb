package com.baizhi.cmfz_zhangcn;

import com.baizhi.zcn.CmfzZhangcnApplication;
import com.baizhi.zcn.dao.AdminMapper;
import com.baizhi.zcn.entity.Admin;
import com.baizhi.zcn.entity.AdminExample;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CmfzZhangcnApplication.class)
public class CmfzZhangcnApplicationTests {

    @Resource
    AdminMapper adminMapper;

    @Autowired
    AdminExample example;

    @Test
    public void inserts() {

        Admin admin1 = adminMapper.queryByUsername("admin");

        System.out.println(admin1);
    }


    @Test
    public void insertss() {

        //分页查询： 参数：忽略几条,获取几条数据
        RowBounds rowBounds = new RowBounds(0,5);

        List<Admin> admins = adminMapper.selectByExampleAndRowBounds(example, rowBounds);

        for (Admin admin1 : admins) {
            System.out.println(admin1);
        }

    }









    @Test
    public void insert() {
        Admin admin = new Admin("6", "ccc", null);

        adminMapper.insert(admin);
        //adminMapper.insertSelective(admin);
    }

    @Test
    public void update() {
        Admin admin = new Admin("666", "hehehe", "222222");

        //相当于是一个条件
        AdminExample example = new AdminExample();
        example.createCriteria().andIdEqualTo("666");


        //adminMapper.updateByPrimaryKey(admin);
        adminMapper.updateByExample(admin,example);
    }


    @Test
    public void delete() {
        Admin admin = new Admin("666", "hehehe", "222222");

        //相当于是一个条件
        AdminExample example = new AdminExample();
        example.createCriteria().andIdBetween("10","30");


        //adminMapper.updateByPrimaryKey(admin);
        //adminMapper.deleteByPrimaryKey("666");
        adminMapper.deleteByExample(example);
    }

    @Test
    public void query() {
        //Admin admin = new Admin("666", "hehehe", "222222");

        //相当于是一个条件
        //AdminExample example = new AdminExample();
        example.createCriteria().andIdIsNotNull();

        List<Admin> admins = adminMapper.selectByExample(example);
        for (Admin admin1 : admins) {
            System.out.println(admin1);
        }

        /*Admin admin = adminMapper.queryByUsername("admin");

        System.out.println(admin);*/
    }

}
