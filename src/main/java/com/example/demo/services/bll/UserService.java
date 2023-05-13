package com.example.demo.services.bll;

import com.example.demo.models.User;
import com.example.demo.services.repository.UserRepository;
import com.example.demo.services.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.List;

@Service
@Transactional
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

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
        String password = user.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String hashPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(hashPassword);
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
}
