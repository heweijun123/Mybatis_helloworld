package com.hwj.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer id;
    private  String name;
    private String course;
    private String address;
    private Date birth;
}
