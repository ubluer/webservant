package com.xyu.module.sys.user.bean;

import com.xyu.core.basebean.BaseBean;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author Xiang.Yu
 * Created by Xiang.Yu on 2015/10/5 0005.
 * @version 0.1.1
 *
 * 用于shiro的用户认证
 */
@Table(name="sys_user")
public class User extends BaseBean{

    private String username;
    private String password;
    @Transient
    private List<Role> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
