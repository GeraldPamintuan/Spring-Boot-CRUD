package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //GET all
    public List<User> getUser(){
        return userRepository.findAll();
    }

    //GET by id
    public Optional<User> getUserById(Long Id){
       return userRepository.findById(Id);
    }

    //POST
    public void addNewUser(User user) {
        Optional<User> userOptional =
                userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()){
            throw new IllegalStateException("username taken");
        }
        userRepository.save(user);
    }

    //DELETE by id
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException(
                    "user with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);

    }

    //PUT
    @Transactional
    public void updateUser(Long userId,
                           String username,
                           String description,
                           String targetDate) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException(
                        "user with id " + userId + " does not exist."
                ));
        //UPDATE username
        if (username != null && username.length() > 0 &&
        !Objects.equals(user.getUsername(), username)){
            Optional<User> userOptional = userRepository
                    .findUserByUsername(username);
            if (userOptional.isPresent()){
                throw new IllegalStateException("username taken");
            }
            user.setUsername(username);
        }
        //UPDATE description
        if (description != null && description.length() > 0 &&
                !Objects.equals(user.getDescription(), description)){
            user.setDescription(description);
        }
        //UPDATE targetDate
        if (targetDate != null && targetDate.length() > 0 &&
                !Objects.equals(user.getTargetDate(), targetDate)){
            user.setTargetDate(targetDate);
        }

    }
}
