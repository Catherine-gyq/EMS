package com.frankzhu.ems.mapper;

import com.frankzhu.ems.model.Course;
import com.frankzhu.ems.model.Elective;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ElectiveMapper {

    // student grade
    @Select("select c.no, c.name, e.grade, c.department, c.redit, c.teacher from course c inner join elective e " +
            "on c.no = e.courseNo where studentNo=#{no} and grade is not null")
    List<Map<String, Object>> findGradeByStudentNo(@Param("no") String no);

    // course average grade
    @Select("select c.name, avg(grade) as avgGrade from course c inner join elective e " +
            "on c.no = e.courseNo where grade is not null group by c.name ")
    List<Map<String, Object>> findAverageGrade();

    // search students
    @Select("select e.id, s.no, s.name, e.grade, s.age, s.sex, s.department from student s inner join elective e " +
            "on s.no = e.studentNo where e.courseNo=#{no}")
    List<Map<String, Object>> findStudentByCourseNo(@Param("no") String no);

    // search enable courses
    @Select("select * from course where no not in (select courseNo from elective where studentNo=#{no})")
    List<Course> findEnableCourseByStudentNo(@Param("no") String no);

    // search own courses
    @Select("select * from course where no in (select courseNo from elective where studentNo=#{no} and grade is null)")
    List<Course> findOwnCourseByStudentNo(@Param("no") String no);

    // search finish courses
    @Select("select * from course where no in (select courseNo from elective " +
            "where studentNo=#{no} and grade is not null)")
    List<Course> findFinishCourseByStudentNo(@Param("no") String no);

    // add
    @Insert("insert into elective (grade, studentNo, courseNo) VALUES (#{grade}, #{studentNo}, #{courseNo})")
    Integer insertElective(Elective elective);

    // update
    @Update("update elective set grade=#{grade} where id=#{id}")
    Integer updateElective(Elective elective);

    // delete
    @Delete("delete from elective where studentNo=#{sno} and courseNo=#{cno}")
    Integer deleteElectiveByNo(@Param("sno") String sno, @Param("cno") String cno);

}
