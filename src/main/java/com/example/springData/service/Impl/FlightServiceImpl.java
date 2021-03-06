package com.example.springData.service.Impl;

import com.example.springData.dto.FlightDTO;
import com.example.springData.model.Flight;
import com.example.springData.repository.FlightRepository;
import com.example.springData.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flights;
    private FlightDTO flightDTO;
    FlightServiceImpl(FlightRepository flights, FlightDTO flightDTO){
        this.flights = flights;
        this.flightDTO = flightDTO;
    }
//    FlightRepository flights = new FlightRepositoryImpl();
    public Flight save(Flight f){
        return flights.save(f);
    }
    public Optional<Flight> findById(Integer id){
        return flights.findById(id);
    }
    public List<Flight> findAll(){
        return flights.findAll();
    }
    public void delete(Flight f){
        flights.delete(f);
    }

    @Override
    public FlightDTO converter(Flight f1) {
//        List<Booking> bookingList = f1.getBookings();
//        List<Integer> bookingIds = new ArrayList<>();
//        for (Booking b:bookingList) {
//            bookingIds.add(b.getId());
//        }
//        flightDTO.setBookingIds(bookingIds);
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setAirline(f1.getAirline());
        flightDTO.setOrigin(f1.getOrigin());
        flightDTO.setDestination(f1.getDestination());
        flightDTO.setStatus(f1.getStatus());
        flightDTO.setDepartureDate(f1.getDepartureDate());
        flightDTO.setArrivalDate(f1.getArrivalDate());
        return flightDTO;
    }

    @Override
    public List<Integer> findAllBookings(Integer id) {
        return flights.findAllById(id);
    }

    @Override
    public List<Integer> findAllUsers(int id) {
        return flights.findAllById(id);
    }
}
