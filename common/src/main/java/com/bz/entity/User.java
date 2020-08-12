package com.bz.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:11411
 * @date: 2020/8/10 17:03
 **/
@Data
public class User implements Serializable {

    private int id;

    private int age;

    private String name;

    private String password;

    /**
     * 用户所属角色组
     */
    private int[] roleIds;
}
