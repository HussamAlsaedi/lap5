package com.example.studentsystem.StudentController;

import com.example.studentsystem.ApiResponse.ApiResponse;
import com.example.studentsystem.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> honors = new ArrayList<>();

    @PostMapping("/addStudent")
    public ApiResponse addStudent(@RequestBody Student student)
    {
        students.add(student);
        return new ApiResponse("added Student successfully");
    }

    @GetMapping("/getStudents")
    public ArrayList<Student> getStudents()
    {
        return students;
    }


     @PutMapping("/updateStudent/{id}")
    public ApiResponse updateStudent(@PathVariable int id, @RequestBody Student student)
    {
        for(Student s : students)
        {
            if (s.getId() == id)
            {
                students.add(s.getId(),student);
                return new ApiResponse("updated Student successfully");
            }
        }
        return new ApiResponse("student not found");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ApiResponse deleteStudent(@PathVariable int id){

        for (Student studentsLoop : students) {
            if (studentsLoop.getId() == id) {
                students.remove(studentsLoop);
                return new ApiResponse("deleted Student successfully");
            }
        }
        return new ApiResponse("student not found");
    }


    @PostMapping("/Honors")
    public ApiResponse Honors(@RequestBody Student student)
    {
        double average = 0;
        double sum = 0;

        for (Student s : honors) {
            sum = s.getGpa();
        }

        average = sum / students.size();

       for (Student s : students) {
           if (s.getGpa() > average) {
               honors.add(s);
               return new ApiResponse("honors added successfully");
           }
       }
       return new ApiResponse("honors not found");
    }

    @GetMapping("/getHonors")
    public ArrayList<Student> getHonors()
    {

        return honors;
    }




}
