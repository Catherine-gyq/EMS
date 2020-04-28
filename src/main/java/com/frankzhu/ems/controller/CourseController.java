package com.frankzhu.ems.controller;

import com.frankzhu.ems.model.Course;
import com.frankzhu.ems.restservice.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/course/all")
    public List<Course> findAllCourse(){
        return courseService.findAllCourse();
    }

    @GetMapping("/api/course/search")
    public Course findCourseByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return courseService.findCourseByNo(no);
    }

    @PostMapping("/api/course/add")
    public Integer insertCourse(@RequestBody Map<String, Object> params) {
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        Integer redit = Integer.parseInt(params.get("redit").toString());
        String department = params.get("department").toString();
        String teacher = params.get("teacher").toString();
        return courseService.insertCourse(new Course(no, name, redit, department, teacher));
    }

    @PostMapping("/api/course/update")
    public Integer updateCourse(@RequestBody Map<String, Object> params){
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        Integer redit = Integer.parseInt(params.get("redit").toString());
        String department = params.get("department").toString();
        String teacher = params.get("teacher").toString();
        return courseService.updateCourse(new Course(no, name, redit, department, teacher));
    }

    @GetMapping("/api/course/delete")
    public Integer deleteCourseByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return courseService.deleteCourseByNo(no);
    }

}
