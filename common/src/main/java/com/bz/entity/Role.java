package com.bz.entity;

import lombok.Data;

/**
 * @author:11411
 * @date: 2020/7/24 15:11
 **/
@Data
public class Role {

    private int id;

    private String name;

    private int[] permissionIds;
}
