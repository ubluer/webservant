package com.xyu.core.ibatis;

import com.xyu.core.spring.SpringContextHolder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Xiang.Yu
 * @version 0.1.1
 * @date 2015/10/11
 * @description MybatisHelper
 */
public class MybatisHelper {
    private static Logger logger = LoggerFactory.getLogger(MybatisHelper.class);
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            try {
                sqlSessionFactory = SpringContextHolder.getBean(SqlSessionFactoryBean.class).getObject();
            } catch (Exception e) {
                logger.error("Cannot get mybatis SqlSessionFactory from spring configuration!");
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }
}
