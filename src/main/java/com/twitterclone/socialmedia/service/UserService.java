package com.twitterclone.socialmedia.service;

import com.twitterclone.socialmedia.model.User;
import com.twitterclone.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public void register(User newUser) throws Exception {
        Optional<User> existingUser = userRepository.findByEmailAddress(newUser.getEmailAddress());
        if (existingUser.isPresent()) {
            throw new Exception("Email already in use");
        }
        userRepository.save(newUser);
    }
}
