package com.schoollist.springapi;

import com.schoollist.springapi.entity.User;
import com.schoollist.springapi.entity.allschool;
import com.schoollist.springapi.mapper.UserMapper;
import com.schoollist.springapi.mapper.allSchoolMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private allSchoolMapper allSchoolMapper;

    @Test
    public void testSelect(){
        System.out.println(("---------test------"));
        List<allschool> allschoolList = allSchoolMapper.selectList(null);
        for(allschool allschool:allschoolList){
            System.out.println(allschool);
        }

    }
}
