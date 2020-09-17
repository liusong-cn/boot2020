package com.bz.mapper;

import com.bz.VO.SysDeptVO;
import com.bz.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:ls
 * @date: 2020/9/16 9:34
 **/
@Mapper
public interface SysDeptMapper {

    int insertDept(SysDept dept);

    int insertDeptDynamic(SysDept dept);

    SysDept findById(String id);

    int updateDept(SysDept dept);

    //目前发现对于int long型的，采用string传参也可以正确识别
    int deleteById(String id);

    int deleteByIds(Long[] ids);

    //遇到需要传递多个参数，而不想用map时，可用@param分别指定，在xml中通过param指定的别名进行调用
    List<SysDept> queryByPage(@Param("dept") SysDept dept, @Param("start") int start, @Param("end") int end);

    List<SysDeptVO> queryDeptWithUser(SysDept dept);

}
