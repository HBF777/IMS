package com.zsc.ims.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-03-03 14:33:30
 */
@SuppressWarnings("serial")
@Data
public class User {
    
    private Integer id;
    private String username;
    private String name;
    
    private String email;
    
    private Integer role;
    //手机号
    private String phone;
    
    private String passwd;
    //创建人的用户id
    private Integer createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Integer updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    //关联角色id数组，非user表字段
    @TableField(exist = false)
    private Integer[] roleIds;
}

