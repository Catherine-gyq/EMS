package com.frankzhu.ems.restservice;

import com.frankzhu.ems.mapper.CourseMapper;
import com.frankzhu.ems.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAllCourse(){
        return courseMapper.findAllCourse();
    }

    public Course findCourseByNo(String no){
        return courseMapper.findCourseByNo(no);
    }

    public Integer insertCourse(Course course){
        return courseMapper.insertCourse(course);
    }

    public Integer updateCourse(Course course){
        return courseMapper.updateCourse(course);
    }

    public Integer deleteCourseByNo(String no){
        return courseMapper.deleteCourseByNo(no);
    }

}
