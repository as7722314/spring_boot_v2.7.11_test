package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;


@Entity(name = "users")
@Table(name = "users")
public class User implements Serializable {
    /** DB Schema */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    @Column(nullable = false, length = 255, name = "email")
    private String email;

    @Column(nullable = false, length = 15, name = "account")
    private String account;

    @Column(nullable = false, length = 255, name = "password")
    private String password;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "job_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "job_t_user",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "job_id"))
    private Job job;

    /** Get Function */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }

    /** Set Function */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public void setPassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String hashPassword = bCryptPasswordEncoder.encode(password);
        this.password = hashPassword;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        var newJob = new Job();
        newJob.setId(job.getId());
        newJob.setJobTitle(job.getJobTitle());
        newJob.setUsers(null);
        return newJob;
    }
}
