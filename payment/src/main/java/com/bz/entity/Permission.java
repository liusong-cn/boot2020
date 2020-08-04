package com.bz.entity;

import lombok.Data;

/**
 * @author:11411
 * @date: 2020/7/24 15:40
 **/
@Data
public class Permission {

    private int id;

    /**
     * 权限编码
     */
    private String perCode;

    /**
     * 权限名称
     */
    private String perName;

    private String roleId;
}
