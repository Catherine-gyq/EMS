package com.frankzhu.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartmentMapper {

    // 获取所有的院系
    @Select("select * from department")
    List<Map<String, Object>> findAllDepartment();

}
