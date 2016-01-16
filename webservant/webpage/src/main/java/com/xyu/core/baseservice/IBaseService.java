package com.xyu.core.baseservice;

import java.util.List;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
public interface IBaseService<T> {
    public T selectByKey(Integer key);
    public List<T> select(T entity);
    public List<T> selectAll();
    public T selectOne(T entity);
    public int selectCount(T entity);

    public int update(T entity);
    public int updateSelective(T entity);

    public int insert(T entity);
    public int insertSelective(T entity);

    public int deleteByKey(Integer key);
    public int delete(T entity);

    /**
     * 逻辑删除
     * @param entity 删除匹配的实体
     * @return 删除的条数
     */
    int deleteLogic(T entity);

    /**存储实体，插入或更新*/
    int save(T entity);
    int saveSelective(T entity);

    /**判断是否是插入*/
     boolean isNew(T entity);
}
