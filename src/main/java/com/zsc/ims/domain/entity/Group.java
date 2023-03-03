package com.zsc.ims.domain.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * (Group)表实体类
 *
 * @author makejava
 * @since 2023-03-03 15:24:26
 */
@SuppressWarnings("serial")
public class Group extends Model<Group> {
    
    private Integer id;
    
    private String name;
    
    private Integer manager;
    
    private Date createdDate;
    
    private Integer delFlag;

}

