package com.example.spring_data.services.Impl;

import com.example.spring_data.DTO.BookingDTO;
import com.example.spring_data.DTO.FlightDTO;
import com.example.spring_data.DTO.UserDTO;
import com.example.spring_data.Repository.UserRepository.UserRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import com.example.spring_data.services.BookingService;
import com.example.spring_data.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository users;
    private BookingService bookings;
    private UserDTO userDTO;
    private BookingDTO bookingDTO;
    UserServiceImpl(UserRepository users, UserDTO userDTO, BookingDTO bookingDTO, BookingService bookings){
        this.users = users;
        this.userDTO = userDTO;
        this.bookingDTO = bookingDTO;
        this.bookings = bookings;
    }
//    UserRepository users = new UserRepositoryImpl();
    public User save(User u){
        return users.save(u);
    }
    public Optional<User> findById(Integer id){
        return users.findById(id);
    }
    public List<User> findAll(){
        return users.findAll();
    }
    public void delete(User u){users.delete(u);}

    public UserDTO converter(User u){
        List<Booking> bookingList = u.getBookings();
        List<BookingDTO> bookingDTOS = new ArrayList<>();
        for (Booking b:bookingList) {
            bookingDTO = bookings.converter(b);
            bookingDTOS.add(bookingDTO);
        }
        userDTO.setBookings(bookingDTOS);
        userDTO.setUserName(u.getUserName());
        userDTO.setRole(u.getRole());
        userDTO.setFirstName(u.getUserDetails().getFirstName());
        userDTO.setLastName(u.getUserDetails().getLastName());
        userDTO.setEmail(u.getUserDetails().getEmail());
        userDTO.setPhoneNumber(u.getUserDetails().getPhoneNumber());
        return userDTO;
    }

}
