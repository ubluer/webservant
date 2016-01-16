package com.xyu.module.sys.user.bean;

import com.xyu.foundation.baseclass.BaseBean;

/**
 * Created by Xiang on 2015/10/11.
 * @author Xiang.Yu
 * @version 0.1.0
 * @description 用户角色
 */
public class UserRole extends BaseBean {
    private String userUid;
    private String roleUid;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }
}
