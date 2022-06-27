package com.example.spring_data.services.Impl;

import com.example.spring_data.DTO.BookingDTO;
import com.example.spring_data.DTO.FlightDTO;
import com.example.spring_data.Repository.BookingRepository.BookingRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.services.BookingService;
import com.example.spring_data.services.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookings;
    private FlightService flights;
    private BookingDTO bookingDTO;
    private FlightDTO flightDTO;
    public BookingServiceImpl(BookingRepository bookings, FlightService flights, BookingDTO bookingDTO, FlightDTO flightDTO) {
        this.bookings = bookings;
        this.flights = flights;
        this.bookingDTO = bookingDTO;
        this.flightDTO = flightDTO;
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

    @Override
    public BookingDTO converter(Booking b) {
//        List<Flight> flightList = b.getFlights();
//        List<FlightDTO> flightDTOS = new ArrayList<>();
//        for (Flight f:flightList) {
//            flightDTO = flights.converter(f);
//            flightDTOS.add(flightDTO);
//        }
//        bookingDTO.setFlights(flightDTOS);
//        List<Flight> flightList = b.getFlights();
//        List<Integer> flightIds = new ArrayList<>();
//        for (Flight f:flightList){
//            flightIds.add(f.getId());
//        }
//        bookingDTO.setFlightIds(flightIds);
        bookingDTO.setUserName(b.getUser().getUserName());
        bookingDTO.setBookingDate(b.getBookingDate());
        bookingDTO.setStatus(b.getStatus());
        return bookingDTO;
    }

    @Override
    public List<Integer> findAllFlights(Integer id) {
        return bookings.findAllById(id);
    }
}
