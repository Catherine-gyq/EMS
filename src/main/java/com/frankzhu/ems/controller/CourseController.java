package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.CourseMapper;
import com.frankzhu.ems.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseMapper courseMapper){
        this.courseMapper=courseMapper;
    }

    @GetMapping("/api/course/all")
    public List<Map<String, Object>> findAllCourse(
            @RequestParam(value = "no", defaultValue = "") String no,
            @RequestParam(value = "name", defaultValue = "") String name){
        return courseMapper.findAllCourse(no, name);
    }

    @PostMapping("/api/course/add")
    public Integer insertCourse(@RequestBody Map<String, Object> params) {
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        Integer credit = Integer.parseInt(params.get("credit").toString());
        String department = params.get("departmentID").toString();
        return courseMapper.insertCourse(new Course(no, name, credit, department));
    }

    @PostMapping("/api/course/update")
    public Integer updateCourse(@RequestBody Map<String, Object> params){
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        Integer credit = Integer.parseInt(params.get("credit").toString());
        return courseMapper.updateCourse(new Course(no, name, credit, null));
    }

    @GetMapping("/api/course/delete")
    public Integer deleteCourseByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return courseMapper.deleteCourseByNo(no);
    }

}
