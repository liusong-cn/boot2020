package com.example.techstudy.service;

import com.example.techstudy.entity.Student;
import com.example.techstudy.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Administrator
 * @date: 2021/3/9 0:20
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public void create(Student student){
        studentMapper.insert(student);
    }
}
