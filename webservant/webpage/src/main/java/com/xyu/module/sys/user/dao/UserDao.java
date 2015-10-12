package com.xyu.module.sys.user.dao;

import com.xyu.core.basedao.BaseDao;
import com.xyu.module.sys.user.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
@Repository("userDao")
public interface UserDao extends BaseDao<User>{

    @Select("select * from users")
    User findByUsername(String username);
}
