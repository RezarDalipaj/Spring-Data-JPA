package com.example.springData.service.Impl;

import com.example.springData.dto.BookingDTO;
import com.example.springData.dto.UserDTO;
import com.example.springData.model.Booking;
import com.example.springData.model.User;
import com.example.springData.model.UserDetails;
import com.example.springData.repository.UserRepository;
import com.example.springData.service.BookingService;
import com.example.springData.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BookingService bookingService;
    UserServiceImpl(UserRepository userRepository, BookingService bookingService) {
        this.userRepository = userRepository;
        this.bookingService = bookingService;
    }

    //    UserRepository users = new UserRepositoryImpl();
    public UserDTO save(User u) {
        User user = userRepository.save(u);
        return converter(user);
    }

    public User findById(Integer id) {
        Optional <User> user = userRepository.findById(id);
        if (user.isPresent()){
            User user1 = user.get();
            return user1;
        }
        else {
            return null;
        }
    }

    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = userRepository.findAll().stream().map(this::converter).collect(Collectors.toList());
        return userDTOs;
    }

    public void delete(User u) {
        userRepository.delete(u);
    }

    public UserDTO converter(User u) {
//        List<Booking> bookingList = u.getBookings();
//        List<BookingDTO> bookingDTOS = new ArrayList<>();
//        for (Booking b:bookingList) {
//            bookingDTO = bookings.converter(b);
//            bookingDTOS.add(bookingDTO);
//        }
//        userDTO.setBookings(bookingDTOS);
//        List<Booking> bookingList = u.getBookings();
//        List<Integer> bookingIds = new ArrayList<>();
//        for (Booking b:bookingList) {
//            bookingIds.add(b.getId());
//        }
//        userDTO.setBookingIds(bookingIds);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(u.getUserName());
        userDTO.setRole(u.getRole());
        userDTO.setFirstName(u.getUserDetails().getFirstName());
        userDTO.setLastName(u.getUserDetails().getLastName());
        userDTO.setEmail(u.getUserDetails().getEmail());
        userDTO.setPhoneNumber(u.getUserDetails().getPhoneNumber());
        return userDTO;
    }

    @Override
    public UserDTO findUserByBookings(Booking b) {
        User user = userRepository.findUserByBookings(b);
        return converter(user);
    }

    @Override
    public List<UserDTO> findAllByRoleContains(String role) {
        List<UserDTO> userDTOs = userRepository.findAllByRoleContains(role).stream().map(this::converter).collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public List<UserDTO> findAllByUserName(String username) {
        List<UserDTO> userDTOs = userRepository.findAllByUserName(username).stream().map(this::converter).collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public UserDTO findAllByUserDetails(UserDetails ud) {
         User user = userRepository.findAllByUserDetails(ud);
         return converter(user);
    }

    @Override
    public List<Integer> findAllBookings(Integer id) {
        return userRepository.findAllById(id);
    }

    @Override
    public List<Integer> findAllFlights(int id) {
        return userRepository.findAllById(id);
    }

}
