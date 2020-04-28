package com.frankzhu.ems.restservice;

import com.frankzhu.ems.mapper.ElectiveMapper;
import com.frankzhu.ems.model.Course;
import com.frankzhu.ems.model.Elective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ElectiveService {

    @Autowired
    private ElectiveMapper electiveMapper;

    public List<Map<String, Object>> findGradeByStudentNo(String no){
        return electiveMapper.findGradeByStudentNo(no);
    }

    public List<Map<String, Object>> findAverageGrade(){
        return electiveMapper.findAverageGrade();
    }

    public List<Map<String, Object>> findStudentByCourseNo(String no){
        return electiveMapper.findStudentByCourseNo(no);
    }

    public List<Course> findEnableCourseByStudentNo(String no){
        return electiveMapper.findEnableCourseByStudentNo(no);
    }

    public List<Course> findOwnCourseByStudentNo(String no){
        return electiveMapper.findOwnCourseByStudentNo(no);
    }

    public List<Course> findFinishCourseByStudentNo(String no){
        return electiveMapper.findFinishCourseByStudentNo(no);
    }

    public Integer insertElective(Elective elective){
        return electiveMapper.insertElective(elective);
    }

    public Integer updateElective(Elective elective){
        return electiveMapper.updateElective(elective);
    }

    public Integer deleteElectiveByNo(String sno, String cno){
        return electiveMapper.deleteElectiveByNo(sno, cno);
    }

}
