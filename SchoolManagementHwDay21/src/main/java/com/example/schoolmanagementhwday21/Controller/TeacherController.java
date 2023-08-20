package com.example.schoolmanagementhwday21.Controller;

import com.example.schoolmanagementhwday21.ApiResponse.ApiResponse;
import com.example.schoolmanagementhwday21.Model.Teacher;
import com.example.schoolmanagementhwday21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){

        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }




}
