package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String imagePath;
    private String gender;

    @ElementCollection
    private List<String> departments;

    private double salary;
    private String startDate;
}
