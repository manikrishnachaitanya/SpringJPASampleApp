package com.example.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.business.Student;


public interface StudentDBRepository extends CrudRepository<Student, String>
{

    /*public Student getStudent(String id)
    {
        return studentStore.get(id);
    }*/

}
