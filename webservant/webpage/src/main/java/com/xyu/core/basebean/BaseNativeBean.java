package com.xyu.core.basebean;

/**
 * @author Xiang.Yu
 * Created by Xiang.Yu on 2015/10/5 0005.
 * @version 0.0.1
 *
 * 从BaseCoreBean继承出，增加对自增id的处理
 */
public class BaseNativeBean extends BaseCoreBean{
    /**
     * 自增长id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
