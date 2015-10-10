package com.xyu.sys.user.service.impl;

import com.xyu.core.baseservice.BaseServiceImpl;
import com.xyu.sys.user.bean.User;
import com.xyu.sys.user.dao.UserDao;
import com.xyu.sys.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UserDao userDao;

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
