package com.example.demo.services;

import com.example.demo.collection.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    MongoOperations operations;

    public List<Student> getstudent()
    {
        //MongoTemplate operations = new MongoTemplate((MongoDatabaseFactory) client);

        System.out.println(operations.findAll(Student.class));

        return operations.findAll(Student.class);

    }

    public Student addStudent(Student student)
    {
 //       MongoTemplate operations = new MongoTemplate(MongoClients.create("mongodb://localhost:27017"),"student");
        System.out.println("In addStudent Method");

        try {
            operations.insert(student);
            return student;
        }catch (Exception e)
        {
            System.out.println(e);
            Student s1 = new Student();
            s1.setName("No");
            return s1;
        }


        //return student;
    }


}
