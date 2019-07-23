package com.baizhi.controller;

import com.baizhi.entity.Teacher;
import com.baizhi.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Timer;

@Controller
@RequestMapping("/hu")
public class TestCotroller {
    @Autowired
    TeacherMapper teacherMapper;
    @RequestMapping("/test1")
   @ResponseBody
    public List<Teacher> test1(){
        List<Teacher> teachers = teacherMapper.selectAll();
        return teachers;
    }
    @RequestMapping("/test2")
    public void test2(){
        Timer timer = new Timer();
        timer.schedule(new Mytimer(),0,1000);
    }
}
