package com.example.demo.services.bll;

import com.example.demo.models.Job;
import com.example.demo.services.interfaces.JobInterface;
import com.example.demo.services.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobService implements JobInterface {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return null;
    }

    @Override
    public Job addJob(Job job) {
        var newJob = jobRepository.save(job);
        return newJob;
    }

    @Override
    public Job updateJob(Long id, Job job) {
        return null;
    }

    @Override
    public void deleteJob(Long id) {

    }
}
