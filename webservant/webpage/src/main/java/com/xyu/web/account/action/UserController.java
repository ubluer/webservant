package com.xyu.web.account.action;

import com.xyu.common.utlis.Encoder;
import com.xyu.common.utlis.StringUtils;
import com.xyu.sys.user.bean.User;
import com.xyu.sys.user.service.IUserService;
import com.xyu.sys.user.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/11
 * @description 用户管理
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @RequestMapping("create-new")
    public String createNewUser(HttpServletRequest request,HttpServletResponse response){
        User newUser = new User();
        newUser.setUsername("xiangyu");
        String password="123456";
        String pass=Encoder.encodeHex("123456".getBytes());
        newUser.setPassword(pass);
        userService.insert(newUser);
        return "a";
    }
}
