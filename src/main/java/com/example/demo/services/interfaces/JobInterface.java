package com.example.demo.services.interfaces;


import com.example.demo.models.Job;

import java.util.List;

public interface JobInterface {

    List<Job> getAll();

    Job getJobById(Long id);

    Job addJob(Job job);

    Job updateJob(Long id, Job job);

    void deleteJob(Long id);
}
