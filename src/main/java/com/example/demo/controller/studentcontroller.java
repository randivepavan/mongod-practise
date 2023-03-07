package com.example.demo.controller;

import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ListIterator;

@RestController
public class studentcontroller {

    @Autowired
    StudentService service;

    @GetMapping(value = "/student")
    public List<com.example.demo.collection.Student> getDetails()
    {
        List<com.example.demo.collection.Student> list1 = service.getstudent();
        ListIterator<com.example.demo.collection.Student> namesIterator = list1.listIterator();
        while(namesIterator.hasNext())
        {
            System.out.println(namesIterator.next());
        }
        return list1;
    }

    @PostMapping(value="/save")
    public ResponseEntity<?> addStudent(@RequestBody com.example.demo.collection.Student student)
    {
        com.example.demo.collection.Student s1 = service.addStudent(student);
        return new ResponseEntity<>("Student Added successfully", HttpStatus.OK);


    }
}
