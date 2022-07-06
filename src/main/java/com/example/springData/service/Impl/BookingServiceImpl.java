package com.example.springData.service.Impl;

import com.example.springData.dto.BookingDTO;
import com.example.springData.dto.FlightDTO;
import com.example.springData.model.Booking;
import com.example.springData.repository.BookingRepository;
import com.example.springData.service.BookingService;
import com.example.springData.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private FlightService flightService;
    public BookingServiceImpl(BookingRepository bookingRepository, FlightService flightService) {
        this.bookingRepository = bookingRepository;
        this.flightService = flightService;
    }

    public Booking save(Booking b){
        return bookingRepository.save(b);
    }
    public Optional<Booking> findById(Integer id){
        return bookingRepository.findById(id);
    }
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
    public void delete(Booking u){
            bookingRepository.delete(u);
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
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setUserName(b.getUser().getUserName());
        bookingDTO.setBookingDate(b.getBookingDate());
        bookingDTO.setStatus(b.getStatus());
        return bookingDTO;
    }

    @Override
    public List<Integer> findAllFlights(Integer id) {
        return bookingRepository.findAllById(id);
    }
}
