package com.xyu.core.baseservice;


import com.xyu.core.basedao.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract protected BaseMapper<T> getDao();

//    public int update(T entity) {
//        return getDao().update(entity);
//    }

    public int insert(T entity) {
        return getDao().insert(entity);
    }

//    public int delete(T entity) {
//        return 0;
//    }

//    public int deleteLogic(T entity) {
//        return 0;
//    }
}
