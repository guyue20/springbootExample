package com.baizhi;

import com.baizhi.entity.Teacher;
import com.baizhi.mapper.TeacherMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSampleApplicationTests {
    @Autowired
    TeacherMapper teacherMapper;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test1(){
        Teacher teacher = new Teacher();
        teacher.setUser_name("zhangsan");
        System.out.println(teacherMapper.select(teacher));
       // System.out.println(teacherMapper.selectByExample(teacher));
      //  System.out.println(teacherMapper.selectAll());

    }
    @Test
    public void MD(){
        Md5Hash abcd = new Md5Hash("123456", "ABCD", 1024);
        String s = abcd.toHex();
        System.out.println(s);
    }

}
