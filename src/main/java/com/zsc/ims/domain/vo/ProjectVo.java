package com.zsc.ims.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ProjectVo {
    private Integer id;
    private String ProjectName;
//    private Integer groupId;
    private Integer status;
    private BigDecimal totalCost;
//    private Date create_time;
//    private Date update_time;
    private Date start_time;
    private Date end_time;
}
