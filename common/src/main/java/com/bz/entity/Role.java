package com.bz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:11411
 * @date: 2020/7/24 15:11
 **/
@Data
public class Role implements Serializable {

    private static final Long serialVersionUID = 2l;

    private int roleId;

    private String roleName;

    private int[] permissionIds;
}
