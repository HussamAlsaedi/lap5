package com.example.projectsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private int Id;
    private String Title;
    private String Description;
    private String status ;
    private String companyName;

}
