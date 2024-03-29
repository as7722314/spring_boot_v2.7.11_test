package com.example.demo.controller;

import com.example.demo.dao.JobRequestDto;
import com.example.demo.models.Job;
import com.example.demo.services.bll.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAll();
    }

    @GetMapping("/job/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/job")
    public Job addJobAndUser(@RequestBody JobRequestDto jobRequestDto){
        return jobService.addJob(jobRequestDto.getJob());
    }



}
