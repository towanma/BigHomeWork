package com.schoollist.springapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.schoollist.springapi.entity.allschool;
import com.schoollist.springapi.mapper.allSchoolMapper;
import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class schoolController {
    @Autowired
    private allSchoolMapper allSchoolMapper;

    @PostMapping("/pschool")
    @CrossOrigin
//    public List<allschool> postInfo( HttpServletRequest request) {
    public List<allschool> postInfo(@RequestParam String School) {
       // StringBuffer jsonStr = RequestUtil.getRequestURL(request);
       // System.out.println(request);
       // System.out.println(jsonStr);
       // queryWrapper.in("city", Arrays.asList(School)).select("*");

        QueryWrapper<allschool> queryWrapper =new QueryWrapper<>();
         queryWrapper.like("type",School);
        return allSchoolMapper.selectList(queryWrapper);
    }

    @PostMapping("/test")
    @CrossOrigin

    public String test(@RequestParam String School) {
        Requ requ = new Requ(School);
        System.out.println(requ.getSchool());
        return requ.getSchool();
    }

    @GetMapping("/pschool")
    @CrossOrigin
    public List<allschool> getInfo(HttpServletRequest request) {
        StringBuffer jsonStr = RequestUtil.getRequestURL(request);
        System.out.println(jsonStr);
        return allSchoolMapper.selectList(null);
    }








}
