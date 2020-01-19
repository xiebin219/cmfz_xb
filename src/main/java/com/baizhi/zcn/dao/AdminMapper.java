package com.baizhi.zcn.dao;

import com.baizhi.zcn.entity.Admin;
import com.baizhi.zcn.entity.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {


    Admin queryByUsername(String username);
}