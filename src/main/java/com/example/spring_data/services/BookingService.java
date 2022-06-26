package com.example.spring_data.services;

import com.example.spring_data.DTO.BookingDTO;
import com.example.spring_data.DTO.FlightDTO;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface BookingService {
    public Booking save(Booking b);
    public Optional<Booking> findById(Integer id);
    public List<Booking> findAll();
    public void delete(Booking u);
    public BookingDTO converter(Booking b);

}
