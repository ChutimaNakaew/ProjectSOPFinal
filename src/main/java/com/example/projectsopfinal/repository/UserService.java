package com.example.projectsopfinal.repository;

import com.example.projectsopfinal.model.Tour;
import com.example.projectsopfinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(String id){
        return userRepository.findById(id);
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }

    public void chage(String bank, String id)
    {
        User u = new User();
        u = userRepository.findById(id).get();
        u.setBank(bank);
        userRepository.save(u);
    }
    public User getUserById(String id){
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("Tour not found for id ::"+ id);
        }
        return user;
    }
}
