package com.xyu.web.account.action;

import com.xyu.module.sys.config.Global;
import com.xyu.module.sys.user.bean.User;
import com.xyu.foundation.utils.CacheUtils;
import com.xyu.common.utlis.CookieUtils;
import com.xyu.foundation.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/6 0006
 * 账户登录跳转
 */
@Controller
public class AccountController {
    @RequestMapping(value = {"index",""})
    public String account(HttpServletRequest request,HttpServletResponse response){
        return "cover/cover-index";
    }

    /**
     * 跳转至登录页面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = UserUtils.getUser();
        // 如果已经登录，则跳转到管理首页
        if(user.getId() != null){
            return "redirect:"+"cover/index.do";
        }
        return "account/login";
    }
    /**
     * 真正登录的POST请求由Filter完成
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, HttpServletRequest request, HttpServletResponse response, Model model) {
        User user = UserUtils.getUser();
        // 如果已经登录，则跳转到管理首页
        if(user.getId() != null){
            return "redirect:"+ "cover/index.do";
        }
//        vo.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
//        vo.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
        return "redirect:"+"login.do";
    }
    /**
     * 登录成功，进入管理首页
     */
    @RequiresUser
    @RequestMapping(value = "account/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        User user = UserUtils.getUser();
        // 未登录，则跳转到登录页
        if(user.getId() == null){
            return "redirect:"+Global.getAdminPath()+"/login";
        }
        // 登录成功后，验证码计算器清零
        isValidateCodeLogin(user.getUsername(), false, true);
        // 登录成功后，获取上次登录的当前站点ID
        UserUtils.putCache("siteId", CookieUtils.getCookie(request, "siteId"));
        return "index";
    }
    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtils.getSubject().logout();
        //return "redirect:http://www.csyd.com/sso/ssoexit.aspx?ReturnUrl=http://10.155.40.49:8080/jeesite/a/login";
        return "";
    }

    /**
     * 是否是验证码登录
     * @param useruame 用户名
     * @param isFail 计数加1
     * @param clean 计数清零
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean){
        Map<String, Integer> loginFailMap = (Map<String, Integer>) CacheUtils.get("loginFailMap");
        if (loginFailMap==null){
            loginFailMap = new HashMap<String, Integer>();
            CacheUtils.put("loginFailMap", loginFailMap);
        }
        Integer loginFailNum = loginFailMap.get(useruame);
        if (loginFailNum==null){
            loginFailNum = 0;
        }
        if (isFail){
            loginFailNum++;
            loginFailMap.put(useruame, loginFailNum);
        }
        if (clean){
            loginFailMap.remove(useruame);
        }
        return loginFailNum >= 3;
    }
}
