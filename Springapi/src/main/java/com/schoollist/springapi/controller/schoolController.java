package com.schoollist.springapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.schoollist.springapi.entity.allschool;
import com.schoollist.springapi.entity.schoolVo;
import com.schoollist.springapi.mapper.allSchoolMapper;
import io.swagger.models.auth.In;
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
    public List<allschool> postInfo(@RequestParam String value, String key) {
        QueryWrapper<allschool> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(key, value);
        return allSchoolMapper.selectList(queryWrapper);
    }


    @PostMapping("/pgch")
    @CrossOrigin
    public List<allschool> postGch(@RequestParam String value) {
        QueryWrapper<allschool> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.like("province", value).or().like("schoolname", value));
        return allSchoolMapper.selectList(queryWrapper);
    }

    @GetMapping("/pschool")
    @CrossOrigin
    public List<allschool> getInfo(HttpServletRequest request) {
        StringBuffer jsonStr = RequestUtil.getRequestURL(request);
        System.out.println(jsonStr);
        return allSchoolMapper.selectList(null);
    }

    @PostMapping("/pag")
    @CrossOrigin
    public schoolVo queryList(Integer current, Integer size, String schoolame) {
        schoolVo schoolVo = new schoolVo();
        IPage<allschool> page = new Page<>(current, size);
        QueryWrapper<allschool> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("schoolname", schoolame);
        allSchoolMapper.selectPage(page, queryWrapper);
        schoolVo.setCurrent(current);
        schoolVo.setSize(size);
        schoolVo.setTotal(page.getTotal());
        schoolVo.setAllschoolList(page.getRecords());
        return schoolVo;
    }


}
