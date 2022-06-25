package com.example.spring_data.services.Impl;

import com.example.spring_data.Repository.FlightRepository.FlightRepository;
import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import com.example.spring_data.services.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flights;
    FlightServiceImpl(FlightRepository flights){
        this.flights = flights;
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
}
