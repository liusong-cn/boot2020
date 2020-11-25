package com.bz.domain;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysDept)实体类
 *
 * @author makejava
 * @since 2020-09-16 09:12:20
 */
@Data
public class SysDept extends BaseEntity{

    /**
    * 部门id
    */
    private Long deptId;
    /**
    * 部门名称
    */
    private String deptName;
    /**
    * 父部门id
    */
    private Long parentId;
    /**
    * 显示顺序
    */
    private Integer orderNum;
    /**
    * 部门领导
    */
    private String leader;




}