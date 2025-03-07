package com.bridgelabz.employeepayrollapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String profilePic;
    private String gender;

    @ElementCollection
    private List<String> departments;

    private double salary;

    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    private String note;
}
