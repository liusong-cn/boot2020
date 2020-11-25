package com.bz.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-09-16 09:12:30
 */
@Data
public class SysRole extends BaseEntity {

    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 角色中文名
    */
    private String roleName;
    /**
    * 角色key
    */
    private String roleKey;
    /**
    * 显示顺序
    */
    private Integer roleSort;

    /**
    * 备注
    */
    private String remark;


}