package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.DepartmentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private final DepartmentMapper departmentMapper;

    public DepartmentController(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    @GetMapping("/api/department/all")
    public List<Map<String, Object>> findAllDepartment(){
        return departmentMapper.findAllDepartment();
    }

}
