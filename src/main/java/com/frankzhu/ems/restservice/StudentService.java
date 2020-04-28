package com.frankzhu.ems.restservice;

import com.frankzhu.ems.mapper.StudentMapper;
import com.frankzhu.ems.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAllStudent(){
        return studentMapper.findAllStudent();
    }

    public Student findStudentByNo(String no){
        return studentMapper.findStudentByNo(no);
    }

    public Integer insertStudent(Student student){
        return studentMapper.insertStudent(student);
    }

    public Integer updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    public Integer deleteStudentByNo(String no){
        return studentMapper.deleteStudentByNo(no);
    }
}
