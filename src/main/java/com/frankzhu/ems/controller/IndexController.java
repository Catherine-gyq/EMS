package com.frankzhu.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    // 访问根URL时候直接跳转到login界面
    @GetMapping(value = "/")
    public String Index(){
        return "index";
    }

}
