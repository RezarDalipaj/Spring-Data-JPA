package com.example.spring_data.services;

import com.example.spring_data.model.User;
import com.example.spring_data.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserDetailsService {
    public UserDetails save(UserDetails u);
    public Optional<UserDetails> findById(Integer id);
//    public List<UserDetails> findAll();
//    public void delete(UserDetails u);
}
