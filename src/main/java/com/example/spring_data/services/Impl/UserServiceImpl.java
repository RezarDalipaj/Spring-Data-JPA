package com.example.spring_data.services.Impl;

import com.example.spring_data.Repository.UserRepository.UserRepository;
import com.example.spring_data.model.User;
import com.example.spring_data.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository users;
    UserServiceImpl(UserRepository users){
        this.users = users;
    }
//    UserRepository users = new UserRepositoryImpl();
    public User save(User u){
        return users.save(u);
    }
    public Optional<User> findById(Integer id){
        return users.findById(id);
    }
    public List<User> findAll(){
        return users.findAll();
    }
    public void delete(User u){users.delete(u);}

}
