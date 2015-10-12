package com.xyu.web.resume.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Xiang on 2015/9/13.
 */
@Controller
@RequestMapping(value = "resume")
public class ResumeController {

    @RequestMapping(value={"index",""})
    public String index(){
        return "resume/resume-index";
    }
}
