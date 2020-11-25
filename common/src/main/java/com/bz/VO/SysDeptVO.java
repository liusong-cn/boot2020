package com.bz.VO;

import com.bz.domain.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author:ls
 * @date: 2020/9/16 15:50
 **/
@Data
public class SysDeptVO {

    /**
     * 状态 0-正常 1-禁用
     */
    private String status = "0";
    /**
     *  是否删除 0-正常 1-删除
     */
    private String delFlag = "0";
    /**
     * 创建人用户名
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 父部门id
     */
    private Long parentId;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 部门领导
     */
    private String leader;

    /**
     * 部门中用户
     */
    private List<SysUser> users;
}
