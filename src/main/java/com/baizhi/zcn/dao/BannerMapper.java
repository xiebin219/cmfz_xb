package com.baizhi.zcn.dao;

import com.baizhi.zcn.entity.Banner;
import com.baizhi.zcn.entity.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BannerMapper extends Mapper<Banner> {

    void update(Banner banner);
}