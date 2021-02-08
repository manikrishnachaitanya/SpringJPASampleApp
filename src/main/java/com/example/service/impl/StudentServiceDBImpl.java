package com.example.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
     * API to findStudentById to student repo
     * @param id
     * @return
     */
    public Student findStudentById(int id)
    {
        List<Student> studentList= getAllStudents();
        Student requiredStudent= studentList.stream().filter(student -> id==student.getId()).findAny().orElse(null);
        return  requiredStudent;
    }

    /**
     * API to deleteStudentById to student repo
     * @param id
     * @return
     */
    public Student deleteStudentById(int id)
    {
        List<Student> studentList = getAllStudents();
        Student requiredStudent = studentList.stream().filter(student -> id == student.getId()).findAny().orElse(null);
        if(requiredStudent !=null)
        {
            studentDBRepository.delete(requiredStudent);
        }
        return requiredStudent;
    }


    /**
     * API to delete all students in student repo
     * @return
     */
    public void deleteAll()
    {
        studentDBRepository.deleteAll();
    }

    /**
     * API to display count of all in student repo
     * @return
     */
    public long count()
    {
        return studentDBRepository.count();
    }

    /**
     * API to add student to student repo
     * @return
     */
    public List<Student> listAllStudents()
    {
        List<Student> studentList = getAllStudents();
        if (studentList != null)
            return studentList;
        return null;
    }

    private List<Student> getAllStudents()
    {
        try
        {
            List<Student> studentList = new ArrayList<>();
            Iterable<Student> iterable = studentDBRepository.findAll();
            Iterator<Student> iterator = iterable.iterator();
            while (iterator.hasNext())
            {
                Student student = iterator.next();
                System.out.println("DEBUG :: ADDING STUDENT  " + student);
                studentList.add(student);
            }

            return studentList;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
