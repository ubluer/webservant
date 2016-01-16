package com.xyu.web.account.action;

import com.xyu.common.utlis.Encoder;
import com.xyu.foundation.vo.AjaxJson;
import com.xyu.module.sys.user.bean.User;
import com.xyu.module.sys.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("list")
    public String list(HttpServletRequest request,HttpServletResponse response) {
        return "system/user/user-list";
    }

    @RequestMapping("data")
    @ResponseBody
    public AjaxJson data(User query, HttpServletRequest request,HttpServletResponse response) {
        AjaxJson aj=new AjaxJson();
        if(query==null) {
            aj.setObj(this.userService.selectAll());
        }
        return aj;
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxJson save(@RequestBody User entity, HttpServletRequest request,HttpServletResponse response) {
        AjaxJson aj =new AjaxJson();
        if(entity!=null){
            int result=this.userService.save(entity);
            if(result>0) {
                aj.setSuccess(true);
            } else {
                aj.setSuccess(false);
                aj.setMsg("更新数据库失败");
            }
        }
        return aj;
    }
}
