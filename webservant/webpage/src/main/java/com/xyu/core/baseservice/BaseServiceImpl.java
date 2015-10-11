package com.xyu.core.baseservice;


import com.xyu.common.utlis.ReflectionHelper;
import com.xyu.core.basedao.BaseMapper;
import com.xyu.sys.config.ConstantEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract protected BaseMapper<T> getDao();

    public T selectByKey(Integer key) {
        return getDao().selectByPrimaryKey(key);
    }
    public List<T> select(T entity){
        return getDao().select(entity);
    }
    public List<T> selectAll() {
        return  getDao().selectAll();
    }
    public T selectOne(T entity) {
        return getDao().selectOne(entity);
    }
    public int selectCount(T entity){
        return getDao().selectCount(entity);
    }

    public int update(T entity) {
        return getDao().updateByPrimaryKey(entity);
    }
    public int updateSelective(T entity){
        return getDao().updateByPrimaryKeySelective(entity);
    }

    public int insert(T entity) {
        return getDao().insert(entity);
    }

    public int insertSelective(T entity){
        return getDao().insertSelective(entity);
    }

    public int deleteByKey(Integer key){
        return getDao().deleteByPrimaryKey(key);
    }
    public int delete(T entity) {
        return getDao().delete(entity);
    }

    /**
     * 逻辑删除
     * @param entity 删除匹配的实体
     * @return 删除的条数
     */
    public int deleteLogic(T entity) {
        ReflectionHelper.setFieldValue(entity,ConstantEnum.DEL_FLAG_FIELD,ConstantEnum.YesOrNo.YES);
        return this.updateSelective(entity);
    }
}
