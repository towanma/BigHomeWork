package com.schoollist.springapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.schoollist.springapi.entity.allschool;

public interface allSchoolMapper extends BaseMapper<allschool> {
    Integer listCount();
}
