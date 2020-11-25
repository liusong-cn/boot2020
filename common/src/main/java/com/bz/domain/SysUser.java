package com.bz.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-09-16 09:12:30
 */
@Data
public class SysUser extends BaseEntity{
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 部门id
    */
    private Long deptId;
    /**
    * 登录名
    */
    private String loginName;
    /**
    * 用户中文名
    */
    private String userName;
    /**
    * 用户类型 00-系统用户
    */
    private String userType;
    /**
    * 用户性别 0-男 1-女
    */
    private String sex;
    /**
    * 用户密码
    */
    private String password;

    /**
    * 手机号
    */
    private String phonenumber;
    /**
    * 邮箱
    */
    private String email;

    /**
    * 登录ip
    */
    private String loginIp;
    /**
    * 登录时间
    */
    private Date loginDate;

    /**
    * 备注
    */
    private String remark;




}