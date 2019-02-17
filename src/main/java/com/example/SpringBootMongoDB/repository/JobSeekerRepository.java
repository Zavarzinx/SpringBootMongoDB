package com.example.SpringBootMongoDB.repository;

import com.example.SpringBootMongoDB.model.JobSeeker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerRepository extends MongoRepository<JobSeeker, String> {
    public JobSeeker findByFirstName(String firstName);
    public List<JobSeeker> findByAge(int age);

}
