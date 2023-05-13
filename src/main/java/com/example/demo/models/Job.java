package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 255, name = "job_title")
    private String jobTitle;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
