package com.xyu.module.sys.user.bean;

import com.xyu.foundation.baseclass.BaseBean;

/**
 * Created by Xiang on 2015/10/11.
 *
 * @author Xiang.Yu
 * @version 0.1.0
 * @description 角色权限
 */
public class RolePermission extends BaseBean {

    private String roleUid;
    private String permissionUid;

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getPermissionUid() {
        return permissionUid;
    }

    public void setPermissionUid(String permissionUid) {
        this.permissionUid = permissionUid;
    }
}
