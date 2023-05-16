package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "jobs")
@Table(name = "jobs")
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 255, name = "job_title")
    private String jobTitle;

    /** 雙向綁定*/
//    @JsonManagedReference
//    @OneToMany(targetEntity = User.class, fetch = FetchType.EAGER, mappedBy = "job")
//    @JoinColumn(name = "job_id", insertable = false, updatable = false)
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @JoinTable(name = "job_t_user",
//        joinColumns = @JoinColumn(name = "job_id"),
//        inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

//    public List<User> getUsers() {
//        return users;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}
