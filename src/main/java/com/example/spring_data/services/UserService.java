package com.example.spring_data.services;

import com.example.spring_data.DTO.UserDTO;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.User;
import com.example.spring_data.model.UserDetails;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface UserService {
    public User save(User u);
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public void delete(User u);
    public UserDTO converter(User u);
    public List<User> findAllByBookings(Booking b);
    public List<User> findAllByRoleContains(String s);
    public List<User> findAllByUserName(String username);
    public User findAllByUserDetails(UserDetails ud);
    public List<Integer> findAllBookings(Integer id);
    public List<Integer> findAllFlights(int id);


}
