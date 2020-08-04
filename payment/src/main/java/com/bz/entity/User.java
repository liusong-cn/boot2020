package com.bz.entity;

import lombok.Data;

/**
 * @author:11411
 * @date: 2020/7/23 13:52
 **/
@Data
public class User {

    private int id;

    private int age;

    private String name;

    private String password;

    /**
     * 用户所属角色组
     */
    private int[] roleIds;
}
