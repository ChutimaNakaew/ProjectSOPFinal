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
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String annotation;
    private Integer total_tourist;
    private Integer total_price;
    private String tour_name;
    private String province;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private String status;
    private String slip;
}
