package com.xyu.foundation.utils;

import com.xyu.common.utlis.ReflectionHelper;
import com.xyu.common.utlis.UIDGenerator;
import com.xyu.module.sys.config.ConstantEnum;

import java.util.Date;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/17
 * @description EntityUtils 业务实体操作类
 */
public class EntityUtils {
    /**
     * 插入实体时补充信息
     * @param obj 待插入实体
     */
    public static void initEntityInfo(Object obj) {
        if(obj!=null) {
            ReflectionHelper.setFieldValue(obj,"uuid", UIDGenerator.generateUUID());
            ReflectionHelper.setFieldValue(obj,"valid",ConstantEnum.YesOrNo.YES.ordinal());
            ReflectionHelper.setFieldValue(obj,"delFlag",ConstantEnum.YesOrNo.YES.ordinal());
            ReflectionHelper.setFieldValue(obj,"createdDate",new Date());
            ReflectionHelper.setFieldValue(obj,"updatedDate",new Date());
            ReflectionHelper.setFieldValue(obj,"createdBy",UserUtils.getUser());
            ReflectionHelper.setFieldValue(obj,"updatedBy",UserUtils.getUser());
        }
    }

    /**
     * 更新实体时补充信息
     * @param obj 待更新实体
     */
    public static void updateEntityInfo(Object obj) {
        if(obj!=null) {
            ReflectionHelper.setFieldValue(obj,"updatedDate",new Date());
            ReflectionHelper.setFieldValue(obj,"updatedBy",UserUtils.getUser());
        }
    }
}
