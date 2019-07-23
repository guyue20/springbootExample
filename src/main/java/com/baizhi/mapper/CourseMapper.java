package com.baizhi.mapper;

import com.baizhi.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}