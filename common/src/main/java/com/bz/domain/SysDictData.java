package com.bz.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysDictDate)实体类
 *
 * @author makejava
 * @since 2020-09-16 09:12:20
 */
public class SysDictData implements Serializable {
    private static final long serialVersionUID = 812178531638688503L;
    /**
    * 字典数据id
    */
    private Long dictDateId;
    /**
    * 字典类型
    */
    private String dictType;
    /**
    * 字典值
    */
    private String dictValue;
    /**
    * 显示顺序
    */
    private Integer dictSort;
    /**
    * 字典的标签名
    */
    private String dictLable;
    /**
    * 状态 0-正常1-禁用
    */
    private String status;
    /**
    * 创建人
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
    * 备注
    */
    private String remark;


    public Long getDictDateId() {
        return dictDateId;
    }

    public void setDictDateId(Long dictDateId) {
        this.dictDateId = dictDateId;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLable() {
        return dictLable;
    }

    public void setDictLable(String dictLable) {
        this.dictLable = dictLable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}