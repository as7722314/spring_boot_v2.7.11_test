package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @Column(nullable = false, name = "job_id", insertable = false, updatable = false)
    private Long jobId;

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

    public Long getJobId() {
        return jobId;
    }

    /** Set Function */

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

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

}
