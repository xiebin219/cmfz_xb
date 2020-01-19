package com.baizhi.zcn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {

    private String id;

    private String srcImg;

    private String description;

    private String status;

    @Column(name="upload_time")
    private Date uploadTime;

}