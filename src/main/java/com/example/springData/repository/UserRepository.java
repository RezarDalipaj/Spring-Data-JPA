package com.example.springData.repository;

import com.example.springData.model.Booking;
import com.example.springData.model.User;
import com.example.springData.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAllByRoleContains(String s);
    public User findUserByBookings(Booking b);
    public List<User> findAllByUserName(String username);
    public User findAllByUserDetails(UserDetails ud);
    @Query(value = "SELECT id FROM booking WHERE user_id = :id", nativeQuery = true)
    public List<Integer> findAllById(@Param("id") Integer id);
    @Query(value = "SELECT flight_id FROM booking_flight WHERE booking_id = :bookingId", nativeQuery = true)
    public List<Integer> findAllById(@Param("bookingId") int id);

}
