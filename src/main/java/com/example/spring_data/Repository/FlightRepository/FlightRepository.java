package com.example.spring_data.Repository.FlightRepository;

import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
