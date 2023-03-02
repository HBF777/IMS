package com.zsc.ims.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Project {
    private Integer id;
    private String ProjectName;
    private Integer creator;
    private Integer status;
    private BigDecimal totalCost;
}
