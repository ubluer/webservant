package com.xyu.sys.user.service.impl;

import com.xyu.core.baseservice.BaseServiceImpl;
import com.xyu.core.ibatis.MybatisHelper;
import com.xyu.sys.user.bean.User;

import com.xyu.sys.user.mapper.UserMapper;
import com.xyu.sys.user.service.IUserService;
import org.springframework.stereotype.Service;
/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Override
    protected UserMapper getDao() {
        return MybatisHelper.getSqlSession().getMapper(UserMapper.class);
    }

    public User findByUsername(String username) {
        return null;
    }
}
