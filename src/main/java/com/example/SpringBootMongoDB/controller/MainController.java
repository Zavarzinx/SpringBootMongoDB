package com.example.SpringBootMongoDB.controller;

import com.example.SpringBootMongoDB.model.JobSeeker;
import com.example.SpringBootMongoDB.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MainController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @RequestMapping("/create")
    public String create(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int age){
        JobSeeker jobSeeker = jobSeekerService.create(firstName, lastName, age);
        return jobSeeker.toString();
    }

    @RequestMapping("/get")
    public JobSeeker getJobSeeker(@RequestParam String firstName){
        return jobSeekerService.getByFirstName(firstName);
    }

    @RequestMapping("/all")
    public List<JobSeeker> getAll(){
        return jobSeekerService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int age){
        JobSeeker jobSeeker = jobSeekerService.update(firstName, lastName, age);
        return jobSeeker.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName){
        jobSeekerService.delete(firstName);
        return "deleted" + firstName;
    }

    @RequestMapping("/deleteall")
    public String deleteAll(){
        jobSeekerService.deleteAll();
        return "Deleted all records";
    }
}
