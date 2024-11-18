package org.example.validationq2.TaskController;

import jakarta.validation.Valid;
import org.example.validationq2.Model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("get")
    public ResponseEntity getTask(){

        return ResponseEntity.ok(tasks);
    }
        @PostMapping("/add")
        public ResponseEntity<String> addTask(@RequestBody @Valid Task task, Errors errors)
        {
            if (errors.hasErrors())
            {
                String message =errors.getFieldError().getDefaultMessage();
                return  ResponseEntity.status(400).body(message);
            }

            tasks.add(task);
            return ResponseEntity.status(200).body("Task added");

        }


    }

