package com.schoollist.springapi.entity;

import lombok.Data;

@Data
public class allschool {
    private int lineid;
    private String code;
    private String schoolname;
    private String province;
    private String city;
    private String department;
    private String level;
    private String type;
    private String link;
}
