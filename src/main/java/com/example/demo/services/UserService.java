package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUserByName(String nameToFind) {
        return getUsers().stream().filter((x) -> x.getName().equals(nameToFind)).collect(Collectors.toUnmodifiableList());
    }

    public List<User> getUserByAge(int ageToFind) {
        return getUsers().stream().filter((x) -> x.getAge() == ageToFind).collect(Collectors.toUnmodifiableList());
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
