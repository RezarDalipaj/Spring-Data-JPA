package com.example.spring_data.services.Impl;

import com.example.spring_data.Repository.BookingRepository.BookingRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.services.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookings;
    public BookingServiceImpl(BookingRepository bookings) {
        this.bookings = bookings;
    }

    public Booking save(Booking b){
        return bookings.save(b);
    }
    public Optional<Booking> findById(Integer id){
        return bookings.findById(id);
    }
    public List<Booking> findAll(){
        return bookings.findAll();
    }
    public void delete(Booking u){
            bookings.delete(u);
    }
}
