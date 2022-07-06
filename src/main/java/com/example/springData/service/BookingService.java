package com.example.springData.service;

import com.example.springData.dto.BookingDTO;
import com.example.springData.model.Booking;

import java.util.List;
import java.util.Optional;
public interface BookingService {
    public Booking save(Booking b);
    public Optional<Booking> findById(Integer id);
    public List<Booking> findAll();
    public void delete(Booking u);
    BookingDTO converter(Booking b);
    List<Integer> findAllFlights(Integer id);

}
