package com.xyu.core.basedao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 * 数据dao基类
 */
public interface BaseDao<T> {
    /**
     * 查询全部数据
     * @return 实体类集合
     */
    public List<T> findAll();
    /**
     * 插入一条数据
     * @param entity
     * @return 插入成功数目
     */
    public int insert(T entity);
    /**
     * 通过ID查询数据
     * @param id
     * @return
     */
    public T findById(@Param("id") Integer id);
    /**
     * 更新实体数据
     * @param entity
     */
    public int update(T entity);
    /**
     * 逻辑删除指定数据
     * @param entity
     * @return 成功删除的数目
     */
    public int deleteById(@Param("id") Integer id);
    /**
     * 物理删除指定数据
     * @param entity
     * @return 成功删除的数目
     */
    public int deleteForeverById(@Param("id") Integer id);
    /**
     * 更新数据的系统信息
     * @param entity
     * @return
     */

    public int updateSystemInfo(T entity);
}
