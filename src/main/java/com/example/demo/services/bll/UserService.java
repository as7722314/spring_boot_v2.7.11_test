package com.example.demo.services.bll;

import com.example.demo.dao.UserRequestDto;
import com.example.demo.models.Job;
import com.example.demo.models.User;
import com.example.demo.services.repository.JobRepository;
import com.example.demo.services.repository.UserRepository;
import com.example.demo.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;
//    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        if(userRepository.findById(id).isPresent()){
            user = userRepository.findById(id).get();
        }
        return user;
    }

    @Override
    public User addUser(UserRequestDto userRequestDto) {
        var jobId = userRequestDto.getJobId();
        var job = this.jobRepository.findById(jobId).get();
        var user = userRequestDto.getUser();
        user.setJob(job);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User dbUser = this.getUserById(id);
        if(dbUser != null){
            dbUser.setName(user.getName());
            dbUser.setEmail(user.getEmail());
            return userRepository.save(dbUser);
        }else{
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        User dbUser = this.getUserById(id);
        if(dbUser != null){
            userRepository.delete(dbUser);
        }
    }

    @Override
    public List<User> getUserByJobId(Long id) {
        return userRepository.findAllByJob_Id(id);
    }
}
