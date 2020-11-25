package com.bz.test;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_oper_log
 * @author 
 */
@Data
public class SysOperLog implements Serializable {
    /**
     * 操作记录主键
     */
    private Long operId;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 业务类型 0-其他 1-新增 2-修改 3-删除
     */
    private Integer businessType;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 操作人部门
     */
    private String operDept;

    /**
     * 请求地址
     */
    private String operUrl;

    /**
     * 请求ip
     */
    private String operIp;

    /**
     * 操作地址
     */
    private String operLocation;

    /**
     * 操作时间
     */
    private Date operTime;

    /**
     * 错误消息
     */
    private String errorMsg;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysOperLog other = (SysOperLog) that;
        return (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getOperName() == null ? other.getOperName() == null : this.getOperName().equals(other.getOperName()))
            && (this.getOperDept() == null ? other.getOperDept() == null : this.getOperDept().equals(other.getOperDept()))
            && (this.getOperUrl() == null ? other.getOperUrl() == null : this.getOperUrl().equals(other.getOperUrl()))
            && (this.getOperIp() == null ? other.getOperIp() == null : this.getOperIp().equals(other.getOperIp()))
            && (this.getOperLocation() == null ? other.getOperLocation() == null : this.getOperLocation().equals(other.getOperLocation()))
            && (this.getOperTime() == null ? other.getOperTime() == null : this.getOperTime().equals(other.getOperTime()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getOperName() == null) ? 0 : getOperName().hashCode());
        result = prime * result + ((getOperDept() == null) ? 0 : getOperDept().hashCode());
        result = prime * result + ((getOperUrl() == null) ? 0 : getOperUrl().hashCode());
        result = prime * result + ((getOperIp() == null) ? 0 : getOperIp().hashCode());
        result = prime * result + ((getOperLocation() == null) ? 0 : getOperLocation().hashCode());
        result = prime * result + ((getOperTime() == null) ? 0 : getOperTime().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operId=").append(operId);
        sb.append(", title=").append(title);
        sb.append(", businessType=").append(businessType);
        sb.append(", method=").append(method);
        sb.append(", operName=").append(operName);
        sb.append(", operDept=").append(operDept);
        sb.append(", operUrl=").append(operUrl);
        sb.append(", operIp=").append(operIp);
        sb.append(", operLocation=").append(operLocation);
        sb.append(", operTime=").append(operTime);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}