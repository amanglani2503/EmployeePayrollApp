package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @NotBlank(message = "Profile picture cannot be empty")
    private String profilePic;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotEmpty(message = "Departments cannot be empty")
    private List<String> departments;

    @Positive(message = "Salary must be positive")
    private double salary;

    @NotEmpty(message = "Start date cannot be empty")
    @JsonFormat(pattern = "dd MMM yyyy")
    private String startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;
}
