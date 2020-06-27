package com.frankzhu.ems.controller;

import com.frankzhu.ems.mapper.ElectiveMapper;
import com.frankzhu.ems.model.Elective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ElectiveController {

    private final ElectiveMapper electiveMapper;

    @Autowired
    public ElectiveController(ElectiveMapper electiveMapper){
        this.electiveMapper = electiveMapper;
    }

    @GetMapping("/api/elective/find/grade/student")
    public List<Map<String, Object>> findGradeByStudentNo(
            @RequestParam(value = "no", defaultValue = "")String no,
            @RequestParam(value = "term", defaultValue = "")String term){
        return electiveMapper.findGradeByStudentNo(no, term);
    }

    @GetMapping("/api/elective/find/student/course")
    public List<Map<String, Object>> findStudentByOID(@RequestParam(value = "no", defaultValue = "")String oid){
        return electiveMapper.findStudentByCourseNo(oid);
    }

    @PostMapping("/api/elective/find/enableCourse/student")
    public List<Map<String, Object>> findEnableCourseByStudentNo(@RequestBody Map<String, Object> params){
        String no = params.get("no").toString();
        String tno = params.get("tno").toString();
        String tname = params.get("tname").toString();
        String cno = params.get("cno").toString();
        String cname = params.get("cname").toString();
        return electiveMapper.findEnableCourseByStudentNo(no, tno, tname, cno, cname);
    }

    @GetMapping("/api/elective/find/OwnCourse/student")
    public List<Map<String, Object>> findOwnCourseByStudentNo(@RequestParam(value = "no", defaultValue = "") String no){
        return electiveMapper.findOwnCourseByStudentNo(no);
    }

    @PostMapping("/api/elective/add")
    public Integer insertElective(@RequestBody Map<String, Object> params){
        String cno = params.get("courseNo").toString();
        String sno = params.get("studentNo").toString();
        return electiveMapper.insertElective(new Elective(null, null, sno, cno));
    }

    @PostMapping("/api/elective/update")
    public Integer updateElective(@RequestBody Map<String, Object> params){
        Integer id = Integer.parseInt(params.get("id").toString());
        Integer grade = Integer.parseInt(params.get("grade").toString());
        return electiveMapper.updateElective(new Elective(id, grade, null, null));
    }

    @GetMapping("/api/elective/delete")
    public Integer deleteElectiveByNo(
            @RequestParam(value = "sno", defaultValue = "") String sno,
            @RequestParam(value = "cno", defaultValue = "") String cno){
        return electiveMapper.deleteElectiveByNo(sno, cno);
    }

}
