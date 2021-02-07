package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.business.Student;
import com.example.service.impl.StudentServiceDBImpl;

@Controller
@RequestMapping("/student")
public class StudentDBController
{
    @Autowired
    StudentServiceDBImpl studentService;

    @GetMapping("/create")
    public @ResponseBody String createStudent(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "id", defaultValue = "123") Integer id,
            @RequestParam(value = "percentage", defaultValue = "23.45") double percentage)
    {
        // log statement
        System.out.println("Entered method createStudent : TRACE");
        //printBeans();
        Student student = studentService.createStudent(name, id, percentage);

        System.out.println("Saved student successfully " + student);
        return "Saved Student";
    }

    @GetMapping("/get")
    public @ResponseBody Student getStudent(
            @RequestParam(value = "id", defaultValue = "123") Integer id)
    {
        // log statement
        System.out.println("Entered method getStudent : TRACE");
        //printBeans();
        //Student student = studentService.get(name, id, percentage);
        return null;
    }

    @GetMapping("/listAll")
    public @ResponseBody List<Student> listAll()
    {
        // log statement
        System.out.println("Entered method listAll : TRACE");
        return studentService.listAllStudents();
    }


    @GetMapping("/hello")
    public @ResponseBody String hello()
    {
        // log statement
        System.out.println("Entered method Hello : TRACE");
        //printBeans();
        //Student student = studentService.get(name, id, percentage);
        return "Hello";
    }

}
