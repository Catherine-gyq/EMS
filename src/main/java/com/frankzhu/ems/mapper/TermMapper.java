package com.frankzhu.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TermMapper {

    // 获取所有的学期
    @Select("select * from term")
    List<Map<String, Object>> findAllTerm();

    // 更新选课状态
    @Update("update term set choice=#{choice} where no=#{no}")
    void updateTerm(@Param("no") String no, @Param("choice") boolean choice);

}
