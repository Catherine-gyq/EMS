package com.frankzhu.ems.controller;

import com.frankzhu.ems.model.Student;
import com.frankzhu.ems.restservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/api/student/all")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/api/student/search")
    public Student findStudentByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return studentService.findStudentByNo(no);
    }

    @PostMapping("/api/student/add")
    public Integer insertStudent(@RequestBody Map<String, Object> params){
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        String sex = params.get("sex").toString();
        String age = params.get("age").toString();
        String department = params.get("department").toString();
        String loginName = params.get("loginName").toString();
        String password = params.get("password").toString();
        return studentService.insertStudent(new Student(no, name, sex, age, department, loginName, password));
    }

    @PostMapping("/api/student/update")
    public Integer updateStudent(@RequestBody Map<String, Object> params){
        String name = params.get("name").toString();
        String no = params.get("no").toString();
        String sex = params.get("sex").toString();
        String age = params.get("age").toString();
        String department = params.get("department").toString();
        String loginName = params.get("loginName").toString();
        String password = params.get("password").toString();
        return studentService.updateStudent(new Student(no, name, sex, age, department, loginName, password));
    }

    @GetMapping("/api/student/delete")
    public Integer deleteStudentByNo(@RequestParam(value = "no", defaultValue = "") String no){
        return studentService.deleteStudentByNo(no);
    }

}
