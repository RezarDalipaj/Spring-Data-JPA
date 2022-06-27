package com.example.spring_data.MainImpl;

import com.example.spring_data.Repository.BookingRepository.BookingRepository;
import com.example.spring_data.Repository.FlightRepository.FlightRepository;
import com.example.spring_data.Repository.UserRepository.UserRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import com.example.spring_data.services.BookingService;
import com.example.spring_data.services.FlightService;
import com.example.spring_data.services.Impl.BookingServiceImpl;
import com.example.spring_data.services.Impl.FlightServiceImpl;
import com.example.spring_data.services.Impl.UserServiceImpl;
import com.example.spring_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;
@Component
public class BookingMain {
    BookingService booking;
    UserService user;
    FlightService flight;

    public BookingMain(BookingServiceImpl booking, UserServiceImpl user, FlightServiceImpl flight) {
        this.booking = booking;
        this.user = user;
        this.flight = flight;
    }
    public void find(){
//        BookingService booking = new BookingService();
        List<Booking> bookingList = booking.findAll();
        if (bookingList.isEmpty()){
            System.out.println("No bookings yet");
            return;
        }
        System.out.println("All the bookings...\n");
        for (Booking b : bookingList) {
            System.out.println(booking.converter(b));
        }
    }
    public Booking add(){
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        Integer id = 0;
        System.out.println("\nAdding booking\n");
        System.out.println("Enter the booking id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the id of the user who booked the flight");
        int uId = 0;
        try {
            uId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
//        UserService user = new UserService();
        Optional<User> userById = user.findById(uId);
        if (!(userById.isPresent())){
            System.out.println("Couldnt add booking. Invalid user");
            return null;
        }
        System.out.println("The flights of this booking...");
        int result = 0;
//        FlightService flight = new FlightService();
        List<Flight> flights = new ArrayList<>();
        while (result != -1){
            System.out.println("Add one flight id to this booking (-1 to stop)");
            try {
                result = read.nextInt();
                read.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Id should be a number");
                read.nextLine();
            }
            Optional<Flight> flightById = flight.findById(result);
            if (flightById.isPresent()){
                Flight fbyId = flightById.get();
                flights.add(fbyId);
            }
            else if (result != -1){
                System.out.println("This flight doesnt exist");
                return null;
            }
        }
            User ubyId = userById.get();
            Date date = new Date(System.currentTimeMillis());
            System.out.println("Enter the status");
            String status = read.nextLine();
            Optional<Booking> bookingById = booking.findById(id);
            if (bookingById.isPresent()){
                Booking b1 = bookingById.get();
                b1=setter(b1,status,date,ubyId,flights);
                System.out.println("Updated booking with id " + b1.getId());
                return b1;
            }
            else {
                Booking b2 = new Booking();
                b2.setId(null);
                b2=setter(b2,status,date,ubyId,flights);
                System.out.println("Added booking with id " + b2.getId());
                return b2;
            }
    }
    public void findId(){
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        Integer find = 0;
        System.out.println("\nFinding booking by id\n");
        try {
            System.out.println("Enter the booking id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking1 = booking.findById(find);
        if (booking1.isPresent()){
            Booking byId = booking1.get();
            System.out.println(booking.converter(byId));
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public void findAllFlights(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the booking id from which you want to get the flights");
        Integer bId = 0;
        try {
            bId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<Booking> b1 = booking.findById(bId);
        if (!(b1.isPresent())){
            System.out.println("This booking doesnt exist");
            return;
        }
        Booking booking1 = b1.get();
        List<Integer> flights = booking.findAllFlights(bId);
        System.out.println("All the flight id-s of this booking\n");
        int i = 0;
        for (Integer f:flights) {
            System.out.println("Flight #"+ (i+1) +" id: " + f);
            i++;
        }
    }
    public void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        System.out.println("\nDeleting booking\n");
        try {
            System.out.println("Enter the booking id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking2 = booking.findById(find);
        if (booking2.isPresent()){
            Booking bdelete = booking2.get();
            booking.delete(bdelete);
            System.out.println("Deleted booking with id " + bdelete.getId());
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public Booking setter(Booking b1, String status, Date date, User ubyId, List<Flight> flights){
        b1.setStatus(status);
        b1.setBookingDate(date);
        b1.setUser(ubyId);
        b1.setFlights(flights);
        booking.save(b1);
        return b1;
    }
}
