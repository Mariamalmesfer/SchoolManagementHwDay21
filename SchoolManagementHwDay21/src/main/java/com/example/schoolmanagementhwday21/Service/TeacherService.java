package com.example.schoolmanagementhwday21.Service;


import com.example.schoolmanagementhwday21.ApiResponse.ApiException;
import com.example.schoolmanagementhwday21.Model.Teacher;
import com.example.schoolmanagementhwday21.Repository.TeacherRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher(){

        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }



    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("id not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);

    }
    public void deleteTeacher(Integer id){

        Teacher oldcTeacher=teacherRepository.findTeacherById(id);
        if(oldcTeacher==null){
            throw new ApiException("id not found");
        }
        teacherRepository.deleteById(id);
    }


}
