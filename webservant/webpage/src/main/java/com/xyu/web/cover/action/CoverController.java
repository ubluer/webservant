package com.xyu.web.cover.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xiang on 2015/9/29.
 */
@Controller
@RequestMapping(value = "cover")
public class CoverController {

    @RequestMapping(value={"index",""})
    public String index(){
        return "cover/cover-index";
    }
}