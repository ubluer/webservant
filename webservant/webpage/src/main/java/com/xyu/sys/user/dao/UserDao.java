package com.xyu.sys.user.dao;

import com.xyu.core.basedao.BaseDao;
import com.xyu.sys.user.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
public interface UserDao extends BaseDao<User>{

    @Select("select * from users")
    User findByUsername(String username);
}
