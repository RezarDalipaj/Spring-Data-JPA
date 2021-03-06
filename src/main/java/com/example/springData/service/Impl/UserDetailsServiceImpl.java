package com.example.springData.service.Impl;

import com.example.springData.model.UserDetails;
import com.example.springData.repository.UserDetailsRepository;
import com.example.springData.service.UserDetailsService;
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

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return users.findById(id);
    }
    public List<UserDetails> findFirstByFirstName(String fname){
        return users.findAllByFirstNameContainsIgnoreCase(fname);
    }

    @Override
    public List<UserDetails> findFirstByEmail(String email) {
        return users.findAllByEmailContainsIgnoreCase(email);
    }

    public List<UserDetails> findFirstByPhoneNumber(String phone){
        return users.findAllByPhoneNumberContainsIgnoreCase(phone);
    }

//    public List<UserDetails> findAll(){
//        return users.findAll();
//    }
//    public void delete(UserDetails u){users.delete(u);}
}
