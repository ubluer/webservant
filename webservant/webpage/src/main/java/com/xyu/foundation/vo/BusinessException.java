package com.xyu.foundation.vo;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/17
 * @description BusinessException 初始版的错误处理框架
 */
public class BusinessException extends Exception {
    /**错误提示*/
    private String tip;
    // TODO 完善错误定位

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
