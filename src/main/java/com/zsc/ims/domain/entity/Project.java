package com.zsc.ims.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Project {
    private Integer id;
    private String ProjectName;
    private Integer groupId;
    private Integer status;
    private BigDecimal totalCost;
    private Date create_time;
    private Date update_time;
    private Date start_time;
    private Date end_time;
}
