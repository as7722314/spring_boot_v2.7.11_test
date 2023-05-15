package com.example.demo.dao;


import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequestDto {

    @JsonProperty("jobId")
    private Long jobId;

    @JsonProperty("user")
    private User user;

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobId() {
        return jobId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
