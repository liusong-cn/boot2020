package com.bz;

import com.bz.VO.SysDeptVO;
import com.bz.domain.SysDept;
import com.bz.mapper.SysDeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author:ls
 * @date: 2020/9/16 10:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class DeptTest {

    @Resource
    private SysDeptMapper deptMapper;

    @Test
    public void testInsert(){
        SysDept dept = new SysDept();
        dept.setDeptName("后勤部");
        dept.setLeader("张三");
        dept.setOrderNum(2);
        dept.setParentId(null);
        dept.setCreateBy("liusong");
        dept.setCreateTime(new Date());
        dept.setUpdateBy(null);
        dept.setUpdateTime(null);
        //返回0-失败 1-成功
        int r = deptMapper.insertDept(dept);
        //通过dept.getDeptId()可得到主键自增后的id，需mapper.xml中配置
        System.out.println(dept.getDeptId());
    }

    @Test
    public void testInsertDynamic(){
        SysDept dept = new SysDept();
        dept.setDeptName("后勤部");
        dept.setLeader("张三");
        dept.setCreateBy("liusong");
        dept.setCreateTime(new Date());

        //返回0-失败 1-成功
        int r = deptMapper.insertDeptDynamic(dept);
        //通过dept.getDeptId()可得到主键自增后的id，需mapper.xml中配置
        System.out.println(dept.getDeptId());
    }

    @Test
    public void testQueryById(){
        String id = "1";
        SysDept sysDept = deptMapper.findById(id);
    }

    @Test
    public void testUpdate(){
        SysDept dept = new SysDept();
        dept.setDeptName("综合一部");
        dept.setDeptId(1l);
        dept.setLeader("葛优");
        dept.setUpdateBy("liusong");
        dept.setUpdateTime(new Date());
        int r = deptMapper.updateDept(dept);
    }

    @Test
    public void testDeleteById(){
        String id = "2";
        int r = deptMapper.deleteById(id);
    }

    @Test
    public void testDeleteByIds(){
        Long[] ids = new Long[]{3L,4L};
        List<Long> idsList = new ArrayList<>();
        Collections.addAll(idsList,3L,4L);
        Long[] ids1 = new Long[2];
        ids1 = idsList.toArray(ids1);
        //使用Arrays.asList()可数组转list
        int r = deptMapper.deleteByIds(ids);

    }

    @Test
    public void testQueryByPage(){
        int start = 1;
        int end = 3;
        SysDept dept = new SysDept();
        dept.setDeptName("后勤");
        List<SysDept> r = deptMapper.queryByPage(dept,start,end);
    }

    @Test
    public void testQueryWithUser(){
        SysDept dept = new SysDept();
        dept.setDeptName("综合");
        List<SysDeptVO> r = deptMapper.queryDeptWithUser(dept);
    }
}
