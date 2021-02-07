package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.business.Student;
import com.example.service.repository.StudentDBRepository;

@Component
public class StudentServiceDBImpl
{
    @Autowired
    StudentDBRepository studentDBRepository;

    /**
     * API to add student to student repo
     * @param name
     * @param id
     * @param percentage
     * @return
     */
    public Student createStudent(String name, Integer id, double percentage)
    {
        try
        {
            Student student = new Student(name, id, percentage);
            studentDBRepository.save(student);
            return student;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * API to add student to student repo
     * @return
     */
    public List<Student> listAllStudents()
    {
        try
        {
            List<Student> studentList = new ArrayList<>();
            Iterable<Student> iterable = studentDBRepository.findAll();
            iterable.forEach(student -> studentList.add(student));
            return studentList;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
