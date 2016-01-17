package com.xyu.foundation.baseclass;


import com.xyu.common.utlis.ReflectionHelper;
import com.xyu.core.baseservice.IBaseService;
import com.xyu.module.sys.config.ConstantEnum;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/5 0005
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract protected BaseMapper<T> getDao();

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param key
     * @return
     */
    public T selectByKey(Integer key) {
        return getDao().selectByPrimaryKey(key);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param entity
     * @return
     */
    public List<T> select(T entity){
        return getDao().select(entity);
    }

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return
     */
    public List<T> selectAll() {
        return  getDao().selectAll();
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param entity
     * @return
     */
    public T selectOne(T entity) {
        return getDao().selectOne(entity);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param entity
     * @return
     */
    public int selectCount(T entity){
        return getDao().selectCount(entity);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param entity
     * @return
     */
    public int update(T entity) {
        return getDao().updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param entity
     * @return
     */
    public int updateSelective(T entity){
        return getDao().updateByPrimaryKeySelective(entity);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param entity
     * @return
     */
    public int insert(T entity) {
        return getDao().insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param entity
     * @return
     */
    public int insertSelective(T entity){
        return getDao().insertSelective(entity);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param key
     * @return
     */
    public int deleteByKey(Integer key){
        return getDao().deleteByPrimaryKey(key);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param entity
     * @return
     */
    public int delete(T entity) {
        return getDao().delete(entity);
    }
//Example 类查询方法

    /**
     * 根据Example条件进行查询, 这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     * @param example
     * @return
     */
    public List<T> selectByExample(Object example){
        return getDao().selectByExample(example);
    }

    /**
     * 根据Example条件进行查询总数
     * @param example
     * @return
     */
    public int selectCountByExample(Object example){
        return getDao().selectCountByExample(example);
    }

    /**
     * 根据Example条件更新实体record包含的全部属性，null值会被更新
     * @param record
     * @param example
     * @return
     */
    public int updateByExample(T record,Object example){
        return getDao().updateByExample(record,example);
    }

    /**
     * 根据Example条件更新实体record包含的不是null的属性值
     * @param record
     * @param example
     * @return
     */
    public int updateByExampleSelective(T record,Object example){
        return getDao().updateByExampleSelective(record,example);
    }

    /**
     * 根据Example条件删除数据
     * @param example
     * @return
     */
    public int deleteByExample(Object example){
        return getDao().deleteByExample(example);
    }
//RowBounds 分页方式

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record
     * @param rowBounds
     * @return
     */
    public List<T> selectByRowBounds(T record,RowBounds rowBounds){
        return getDao().selectByRowBounds(record,rowBounds);
    }

    /**
     * 根据example条件和RowBounds进行分页查询
     * @param example
     * @param rowBounds
     * @return
     */
    public List<T> selectByExampleAndRowBounds(Object example,RowBounds rowBounds){
        return getDao().selectByExampleAndRowBounds(example,rowBounds);
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

    /**存储实体，插入或更新*/
    public int save(T entity) {
        if(isNew(entity)) {
            return this.insert(entity);
        }else {
            return this.update(entity);
        }
    }

    /**
     * 存储实体，插入或更新,不处理为null的项目
     * @param entity
     * @return
     */
    public int saveSelective(T entity) {
        if(isNew(entity)) {
            return this.insertSelective(entity);
        } else {
            return this.updateSelective(entity);
        }
    }

    /**判断是否是插入*/
    public boolean isNew(T entity) {
        if(entity!=null) {
            if(ReflectionHelper.getFieldValue(entity,"id")!=null) {
                return true;
            }
        }
        return false;
    }
}
