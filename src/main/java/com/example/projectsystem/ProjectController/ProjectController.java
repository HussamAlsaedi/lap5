package com.example.projectsystem.ProjectController;

import com.example.projectsystem.ApiResponse.ApiResponse;
import com.example.projectsystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<Project>();

    @GetMapping("/getProject")
    public ArrayList<Project> getProject() {
        return projects;
    }

    @PostMapping("/addProject")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("success added Project");
    }

    @PutMapping("/updateProject/{id}")
    public ApiResponse updateProject(@PathVariable int id, @RequestBody Project project) {

        for (Project projectLoop : projects) {
            if (projectLoop.getId() == id) {
                projects.set(id,project);
                return new ApiResponse("success update Project");
            }
        }

        return new ApiResponse("Project not in list");
    }

    @DeleteMapping("/deleteProject/{id}")
    public ApiResponse deleteProject(@PathVariable int id) {

        for (Project projectLoop : projects) {
            if (projectLoop.getId() == id) {
                projects.remove(id);
                return new ApiResponse("success delete project");
            }
        }
        return new ApiResponse("Project not in list: "+ id);
    }

    @PutMapping("/checkStatus/{id}")
    public ApiResponse checkStatusProject(@PathVariable int id, @RequestBody Project project) {

        for (Project loopProject : projects)
        {
            if (loopProject.getId() == id  ) {
                if (loopProject.getStatus().equals("Done")) {
                    loopProject.setStatus("Done");
                    return new ApiResponse("Project not Done, updated successfully to Done");
                }
            }
            return new ApiResponse("Project not found");
        }
        return new ApiResponse("Project Already Done");
    }

    @PutMapping("/findProject/{project}")
    public ApiResponse findProject(@PathVariable String project)
    {
        for (Project loopProject : projects) {

            if (loopProject.getTitle().equals(project))
            {
                return  new ApiResponse("We Find The Project"+loopProject.getTitle());
            }

        }
        return  new ApiResponse("Not found a Project");
    }

    @PutMapping("/findProjeCompanyName/{project}")
    public ArrayList<Project> findProjeCompanyName(@PathVariable String project)
    {
        ArrayList<Project> matchingProjects = new ArrayList<>();

        for (Project loopProject : projects) {
            if (loopProject.getCompanyName().equals(project)) {
                matchingProjects.add(loopProject);
            }
        }
        return matchingProjects;
    }
}
