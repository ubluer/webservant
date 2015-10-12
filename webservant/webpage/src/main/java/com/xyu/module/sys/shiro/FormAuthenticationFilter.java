package com.xyu.module.sys.shiro;

import com.xyu.module.sys.config.Global;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Xiang.Yu
 * @version 0.0.2
 * @date 2015/10/7 0007
 * 表单验证（包含验证码）过滤类
 */
@Service
public class FormAuthenticationFilter extends
        org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

    public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
    public static final String DEFAULT_KEY_PARAM = "AuthKey";

    private String captchaParam = DEFAULT_CAPTCHA_PARAM;
    private String keyParam = DEFAULT_KEY_PARAM;

    public String getCaptchaParam() {
        return captchaParam;
    }

    public String getKeyParam() {
        return keyParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    protected String getKey(ServletRequest request) {
        return WebUtils.getCleanParam(request, getKeyParam());
    }

    protected AuthenticationToken createToken(ServletRequest request,
                                              ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String key = getKey(request);
        if (password == null) {
            password = "";
        }
        if (key == null) {
            key = "";
        }
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        String captcha = getCaptcha(request);
        return new UsernamePasswordToken(username, password.toCharArray(),
                rememberMe, host, captcha, key);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        if (Global.isSSOLogin()) {
            return executeLogin(request, response);
        } else {
            return super.onAccessDenied(request, response);
        }

    }

}
