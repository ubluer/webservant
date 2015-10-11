package com.xyu.sys.user.service.impl;

import com.xyu.core.basedao.BaseDao;
import com.xyu.core.baseservice.BaseServiceImpl;
import com.xyu.sys.user.bean.User;
import com.xyu.sys.user.dao.UserDao;
import com.xyu.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<User> getDao() {
        return userDao;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public String test(){
        return "a";
    }
}
