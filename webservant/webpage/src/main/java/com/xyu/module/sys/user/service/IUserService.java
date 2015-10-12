package com.xyu.module.sys.user.service;


import com.xyu.core.baseservice.IBaseService;
import com.xyu.module.sys.user.bean.User;

/**
 * @author Xiang.Yu
 * Created by Administrator on 2015/10/5 0005.
 * @version 0.1.0
 *
 * 用户基础业务接口
 */
public interface IUserService extends IBaseService<User> {

    User findByUsername(String username);
}
