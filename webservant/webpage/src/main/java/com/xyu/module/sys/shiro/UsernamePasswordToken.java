package com.xyu.module.sys.shiro;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/7 0007
 */
public class UsernamePasswordToken extends
        org.apache.shiro.authc.UsernamePasswordToken {

    private static final long serialVersionUID = 1L;

    private String captcha;
    private String key;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public UsernamePasswordToken() {
        super();
    }

    public UsernamePasswordToken(String username, char[] password,
                                 boolean rememberMe, String host, String captcha, String key) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
        this.key = key;
    }

}
