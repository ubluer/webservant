package com.xyu.web.family.action;

import com.xyu.module.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
@Controller
@RequestMapping(value = "family")
public class FamilyController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value={"index",""})
    public String index(){
        userService.findByUsername("1");
        return "family/family-index";
    }
}