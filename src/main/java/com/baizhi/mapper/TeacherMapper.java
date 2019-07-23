package com.baizhi.mapper;

import com.baizhi.entity.Teacher;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface TeacherMapper extends Mapper<Teacher>, MySqlMapper<Teacher> {

    @Select("select * from teacher where user_name=#{user_name}")
    List<Teacher> selecttesthu(Teacher teacher);
}
