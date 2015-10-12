package com.xyu.module.sys.user.bean;

import com.xyu.core.basebean.BaseBean;

import java.util.List;

/**
 * @author Xiang.Yu
 * Created by Administrator on 2015/10/5 0005.
 * @version 0.1.0
 */
public class Role extends BaseBean {
    /** 角色名 */
    private String name;
    /** 权限集 */
    private List<Permission> permissionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
