package com.xyu.web.system.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/12
 * @description SystemController 系统管理页面控制器
 */
@Controller
@RequestMapping("system")
public class SystemController {

    @RequestMapping({"index",""})
    public String index(HttpServletRequest request,HttpServletResponse response){
        return "system/system-index";
    }
}
