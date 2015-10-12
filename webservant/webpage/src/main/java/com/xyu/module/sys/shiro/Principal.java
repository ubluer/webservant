package com.xyu.module.sys.shiro;

import com.xyu.module.sys.user.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/6 0006
 */
public class Principal {
    private Integer id;
    private String username;
    private Map<String, Object> cacheMap;

    public Principal(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getCacheMap() {
        if (cacheMap==null){
            cacheMap = new HashMap<String, Object>();
        }
        return cacheMap;
    }
}
