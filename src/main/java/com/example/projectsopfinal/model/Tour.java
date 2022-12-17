package com.example.projectsopfinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tour")
public class Tour {
    @Id
    private String _id;
    private String name;
    private String province;
    private Double price;
    private String img;
    private String detail_img;
    private Object detail;
    private Integer people;
    private String schedule;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

}
