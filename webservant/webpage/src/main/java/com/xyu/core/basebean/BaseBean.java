package com.xyu.core.basebean;

/**
 * @author Xiang.Yu
 * Created by Xiang.Yu on 2015/10/5.
 * @version 0.0.1
 *
 * 基本的bean基类，实现除主键外的其他一般字段
 */
public class BaseBean extends BaseUuidBean{

    private String createdDate;
    private String createdBy;
    private String updatedDate;
    private String updatedBy;
    private String note;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
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
