package com.schoollist.springapi;

import com.schoollist.springapi.entity.allschool;
import com.schoollist.springapi.mapper.allSchoolMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private allSchoolMapper allSchoolMapper;

    @Test
    public void testSelect(){
        System.out.println(("---------test------"));
        Map<String,Object> map = new HashMap<>() ;
        map.put("level","本科");
        List<allschool> allschoolList = allSchoolMapper.selectByMap(map);
        for(allschool allschool:allschoolList){
            System.out.println(allschool);
        }

    }
}
