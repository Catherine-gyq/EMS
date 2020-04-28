package com.frankzhu.ems.controller;

import com.frankzhu.ems.model.Course;
import com.frankzhu.ems.model.Elective;
import com.frankzhu.ems.restservice.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ElectiveController {

    @Autowired
    private ElectiveService electiveService;

    @GetMapping("/api/elective/find/grade/student")
    public List<Map<String, Object>> findGradeByStudentNo(@RequestParam(value = "no", defaultValue = "")String no){
        return electiveService.findGradeByStudentNo(no);
    }

    @GetMapping("/api/elective/find/averageGrade")
    public List<Map<String, Object>> findAverageGrade(){
        return electiveService.findAverageGrade();
    }

    @GetMapping("/api/elective/find/student/course")
    public List<Map<String, Object>> findStudentByCourseNo(@RequestParam(value = "no", defaultValue = "")String no){
        return electiveService.findStudentByCourseNo(no);
    }

    @GetMapping("/api/elective/find/enableCourse/student")
    public List<Course> findEnableCourseByStudentNo(@RequestParam(value = "no", defaultValue = "") String no){
        return electiveService.findEnableCourseByStudentNo(no);
    }

    @GetMapping("/api/elective/find/OwnCourse/student")
    public List<Course> findOwnCourseByStudentNo(@RequestParam(value = "no", defaultValue = "") String no){
        return electiveService.findOwnCourseByStudentNo(no);
    }

    @GetMapping("/api/elective/find/FinishCourse/student")
    public List<Course> findFinishCourseByStudentNo(@RequestParam(value = "no", defaultValue = "") String no){
        return electiveService.findFinishCourseByStudentNo(no);
    }

    @PostMapping("/api/elective/add")
    public Integer insertElective(@RequestBody Map<String, Object> params){
        String cno = params.get("courseNo").toString();
        String sno = params.get("studentNo").toString();
        return electiveService.insertElective(new Elective(null, null, sno, cno));
    }

    @PostMapping("/api/elective/update")
    public Integer updateElective(@RequestBody Map<String, Object> params){
        Integer id = Integer.parseInt(params.get("id").toString());
        Integer grade = Integer.parseInt(params.get("grade").toString());
        return electiveService.updateElective(new Elective(id, grade, null, null));
    }

    @GetMapping("/api/elective/delete")
    public Integer deleteElectiveByNo(
            @RequestParam(value = "sno", defaultValue = "") String sno,
            @RequestParam(value = "cno", defaultValue = "") String cno){
        return electiveService.deleteElectiveByNo(sno, cno);
    }

}
