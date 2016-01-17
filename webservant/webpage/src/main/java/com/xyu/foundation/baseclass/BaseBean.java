package com.xyu.foundation.baseclass;

import com.xyu.core.basebean.BaseUuidBean;
import com.xyu.module.sys.config.ConstantEnum;
import com.xyu.foundation.utils.UserUtils;

import java.util.Date;

/**
 * @author Xiang.Yu
 * Created by Xiang.Yu on 2015/10/5.
 * @version 0.0.1
 *
 * 基本的bean基类，实现除主键外的其他一般字段
 */
public class BaseBean extends BaseUuidBean {

    private Integer valid;
    private Integer delFlag;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String note;

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
