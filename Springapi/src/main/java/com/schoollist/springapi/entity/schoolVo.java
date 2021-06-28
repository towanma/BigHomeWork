package com.schoollist.springapi.entity;

import lombok.Data;

import java.util.List;

@Data
public class schoolVo {
    private Integer current;
    private Integer size;
    private Long total;
    private List<allschool> allschoolList;
}
