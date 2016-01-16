package com.xyu.core.basebean;

import com.xyu.common.utlis.UIDGenerator;

/**
 * @author Xiang.Yu
 * Created by Administrator on 2015/10/5 0005.
 * @version 0.1.0
 * 扩展uuid字段
 */
public class BaseUuidBean extends BaseNativeBean{
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
