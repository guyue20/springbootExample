package com.baizhi.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int user_id;
//    @Column(name = "user_name")
    private String user_name;
//    @Column(name = "age")
    private int age;
    @Transient
    private String test;

    public Teacher(String user_name, int age, String test) {
        this.user_name = user_name;
        this.age = age;
        this.test = test;
    }

    public Teacher() {
    }
}
