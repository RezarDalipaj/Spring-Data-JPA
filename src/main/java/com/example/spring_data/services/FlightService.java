package com.example.spring_data.services;

import com.example.spring_data.DTO.FlightDTO;
import com.example.spring_data.DTO.UserDTO;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface FlightService {
    public Flight save(Flight f);
    public Optional<Flight> findById(Integer id);
    public List<Flight> findAll();
    public void delete(Flight f);
    public FlightDTO converter(Flight f);
    List<Integer> findAllBookings(Integer id);
    public List<Integer> findAllUsers(int id);

}
