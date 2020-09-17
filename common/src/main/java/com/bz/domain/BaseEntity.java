package com.bz.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用基类
 * @author:ls
 * @date: 2020/9/16 9:22
 **/
@Data
public class BaseEntity implements Serializable {

    private final static Long serialVersionUID = -52936556016440576L;

    /**
     * 状态 0-正常 1-禁用
     */
    private String status = "0";
    /**
     *  是否删除 0-正常 1-删除
     */
    private String delFlag = "0";
    /**
     * 创建人用户名
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;




}
