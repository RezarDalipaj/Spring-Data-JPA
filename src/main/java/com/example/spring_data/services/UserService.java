package com.example.spring_data.services;

import com.example.spring_data.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {
    public User save(User u);
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public void delete(User u);

}
