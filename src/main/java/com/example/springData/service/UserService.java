package com.example.springData.service;

import com.example.springData.dto.UserDTO;
import com.example.springData.model.Booking;
import com.example.springData.model.User;
import com.example.springData.model.UserDetails;

import java.util.List;
import java.util.Optional;
public interface UserService {
    UserDTO save(User u);
    User findById(Integer id);
    List<UserDTO> findAll();
    void delete(User u);
    UserDTO converter(User u);
    UserDTO findUserByBookings(Booking b);
    List<UserDTO> findAllByRoleContains(String s);
    List<UserDTO> findAllByUserName(String username);
    UserDTO findAllByUserDetails(UserDetails ud);
    List<Integer> findAllBookings(Integer id);
    List<Integer> findAllFlights(int id);


}
