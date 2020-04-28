package com.frankzhu.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class IndexController {

    // index page
    @GetMapping(value = "/")
    public String Index(){
        return "index";
    }

    // admin login
    @ResponseBody
    @PostMapping(value = "/api/admin/login")
    public Integer Login(@RequestBody Map<String, Object> params){
        String name = params.get("username").toString();
        String password = params.get("password").toString();
        if (name.equals("admin") && password.equals("admin"))
            return 1;
        return 0;
    }

}
