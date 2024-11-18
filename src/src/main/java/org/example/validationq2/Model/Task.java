package org.example.validationq2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {

    @NotNull(message = "id cannot be null")
    @Min(value = 1, message = "id must be more than 0")
    private Integer id;

    @Size(min = 15, message = "Description must be at least 15 characters long")
    @NotEmpty(message = "Description must not be empty")
    private String description;


    @NotNull(message = "capacity can not be null")
    @Min(value = 26, message = "capacity must be more than 25")
    private Integer  capacity;

    @NotNull(message = "Start Date cannot be null.")
    @Future(message = "Start Date must be in the future.")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date startDate;

    @NotNull(message = "End Date cannot be null.")
    @Future(message = "End Date must be in the future.")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date endDate;




}
