package com.example.SpringBootMongoDB.service;

import com.example.SpringBootMongoDB.model.JobSeeker;
import com.example.SpringBootMongoDB.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekeRepository;

    public JobSeeker create(String firstName, String lastName, int age){
        return jobSeekeRepository.save(new JobSeeker(firstName, lastName, age));
    }

    public List<JobSeeker> getAll(){
        return jobSeekeRepository.findAll();
    }

    public JobSeeker getByFirstName(String firstName){
        return jobSeekeRepository.findByFirstName(firstName);
    }

    public JobSeeker update(String firstName, String lastName, int age){
        JobSeeker jobSeeker = jobSeekeRepository.findByFirstName((firstName));
        jobSeeker.setLastName(lastName);
        jobSeeker.setAge(age);
        return jobSeekeRepository.save(jobSeeker);
    }

    public void deleteAll(){
        jobSeekeRepository.deleteAll();
    }

    public void delete(String firstName) {
        JobSeeker jobSeeker = jobSeekeRepository.findByFirstName((firstName));
        jobSeekeRepository.delete(jobSeeker);
    }

}
