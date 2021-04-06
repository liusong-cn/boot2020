package com.example.techstudy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: Administrator
 * @date: 2021/3/9 0:17
 */
@TableName("student")
@Data
public class Student {

    private String name;

    private int id;

    private int age;

    private String grade;

    private Date beginTime;

    private int sex;
}
