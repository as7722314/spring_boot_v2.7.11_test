package com.example.demo.services.bll;

import com.example.demo.models.User;
import com.example.demo.services.repository.JobRepository;
import com.example.demo.services.repository.UserRepository;
import com.example.demo.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;

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
    public User addUser(User user) {
        var job = jobRepository.findById(user.getJobId()).get();
        List<User> users = new ArrayList<User>();
        users.add(user);
        job.setUsers(users);
        var newJobData = jobRepository.save(job);
        var newUser =  newJobData.getUsers();
        return newUser.get(0);
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
}
