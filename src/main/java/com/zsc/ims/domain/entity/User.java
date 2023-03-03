package com.zsc.ims.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-03-03 14:33:30
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {
    
    private Integer id;
    
    private String name;
    
    private String email;
    
    private Integer role;
    //手机号
    private String phone;
    
    private String passwd;
    
    private Integer delFlag;

}

