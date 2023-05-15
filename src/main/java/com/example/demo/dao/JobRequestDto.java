package com.example.demo.dao;

import com.example.demo.models.Job;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRequestDto {

    @JsonProperty("job")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
