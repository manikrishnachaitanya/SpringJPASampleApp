package com.example.business;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.GenericGenerator;

@Entity // This tells Hibernate to make a table out of this class
public class Student
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int entryId;

    private int id;
    private String name;
    private double percentage;
    private String address;

    public Student()
    {
    }

    public Student(String name, int id, double percentage)
    {
        super();
        this.name = name;
        this.id = id;
        this.percentage = percentage;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getPercentage()
    {
        return percentage;
    }

    public void setPercentage(double percentage)
    {
        this.percentage = percentage;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Student{" + "name='" + name + '\'' + ", id='" + id + '\'' + ", percentage=" + percentage + ", address='"
                + address + '\'' + '}';
    }
}
