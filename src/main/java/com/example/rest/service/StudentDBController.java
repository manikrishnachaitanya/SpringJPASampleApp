package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "Saved Student " + student.toString();
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

    @GetMapping("/findStudent/{id}")
    public @ResponseBody Student findStudentById(
            @PathVariable(value = "id") int id)
    {
        // log statement
        System.out.println("Entered method getStudent : TRACE");
        //printBeans();
       Student student = studentService.findStudentById(id);
        return student;
    }
    @GetMapping("/deleteStudent/{id}")
    public @ResponseBody Student deleteStudentById(
            @PathVariable(value = "id") int id)
    {
        // log statement
        System.out.println("Entered method getStudent : TRACE");
        //printBeans();
        Student student = studentService.deleteStudentById(id);
        return student;
    }

    @GetMapping("/listAll")
    public @ResponseBody List<Student> listAll()
    {
        // log statement
        System.out.println("Entered method listAll : TRACE");
        return studentService.listAllStudents();
    }

    @GetMapping("/deleteAll")
    public @ResponseBody void deleteAll()
    {
        // log statement
        System.out.println("Entered method deleteAll : TRACE");
        studentService.deleteAll();
    }

    @GetMapping("/count")
    public @ResponseBody long count()
    {
        // log statement
        System.out.println("Entered method count : TRACE");
        return studentService.count();
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
