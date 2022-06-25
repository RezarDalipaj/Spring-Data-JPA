package com.example.spring_data.services.Impl;

import com.example.spring_data.Repository.UserDetailsRepository.UserDetailsRepository;
import com.example.spring_data.model.User;
import com.example.spring_data.model.UserDetails;
import com.example.spring_data.services.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    UserDetailsRepository users;
    UserDetailsServiceImpl(UserDetailsRepository users){
        this.users = users;
    }
//    UserDetailsRepository users = new UserDetailsRepositoryImpl();
    public UserDetails save(UserDetails u){
        return users.save(u);
    }
//    public Optional<UserDetails> findById(User u){
//        return users.findById(u);
//    }
//    public List<UserDetails> findAll(){
//        return users.findAll();
//    }
//    public void delete(UserDetails u){users.delete(u);}
}
