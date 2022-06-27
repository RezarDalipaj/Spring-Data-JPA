package com.example.spring_data.MainImpl;

import com.example.spring_data.Repository.FlightRepository.FlightRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.services.FlightService;
import com.example.spring_data.services.Impl.FlightServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class FlightMain {
    FlightService flight;
    public FlightMain(FlightServiceImpl flight){
        this.flight = flight;
    }
    public void find(){
//        FlightService flight = new FlightService();
        List<Flight> flightList = flight.findAll();
        if (flightList.isEmpty()){
            System.out.println("No flights yet");
            return;
        }
        System.out.println("All the flights...\n");
        for (Flight f : flightList) {
            System.out.println(flight.converter(f));
        }
    }
    public void add(){
        Scanner read = new Scanner(System.in);
//        FlightService flight = new FlightService();
        Integer id = 0;
        System.out.println("\nAdding flight\n");
        System.out.println("Enter the flight id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
//        List<User> users = flight.allUsers(id);
        System.out.println("Enter the origin");
        String origin = read.nextLine();
        System.out.println("Enter the destination");
        String dest = read.nextLine();
        System.out.println("Enter the airline");
        String air = read.nextLine();
        Optional<Flight> flightById = flight.findById(id);
        if (flightById.isPresent()){
            Flight f1 = flightById.get();
            f1=setter(f1,origin,air,dest);
            System.out.println("Updated flight with id " + f1.getId());
//            f1.setUsers(users);
        }
        else {
            Flight f2 = new Flight();
            f2.setId(null);
            f2=setter(f2,origin,air,dest);
            System.out.println("Added flight with id "+f2.getId());
//            f2.setUsers(users);
        }
    }
    public void findId(){
        Scanner read = new Scanner(System.in);
//        FlightService flight = new FlightService();
        Integer find = 0;
        System.out.println("\nFinding flight by id\n");
        try {
            System.out.println("Enter the flight id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight1 = flight.findById(find);
        if (flight1.isPresent()){
            Flight byId = flight1.get();
            System.out.println(flight.converter(byId));
        }
        else
            System.out.println("This flight doesnt exist");
    }
    public void findAllBookings(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the flight id from which you want to get the bookings");
        Integer fId = 0;
        try {
            fId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<Flight> f1 = flight.findById(fId);
        if (!(f1.isPresent())){
            System.out.println("This flight doesnt exist");
            return;
        }
        Flight flight1 = f1.get();
        List<Integer> bookings = flight.findAllBookings(fId);
        if (bookings.isEmpty()){
            System.out.println("This flight has no bookings yet");
            return;
        }
        System.out.println("All the booking id-s of this flight\n");
        int i = 0;
        for (Integer b:bookings) {
            System.out.println("Booking #"+ (i+1) +" id: " + b);
            i++;
        }
    }
    public void findAllUsers(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the flight id from which you want to get the users");
        int fId = 0;
        try {
            fId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<Flight> f1 = flight.findById(fId);
        if (!(f1.isPresent())){
            System.out.println("This flight doesnt exist");
            return;
        }
        Flight flight1 = f1.get();
        List<Integer> users = flight.findAllUsers(fId);
        if (users.isEmpty()){
            System.out.println("This flight has no users yet");
            return;
        }
        System.out.println("All the user id-s of this flight\n");
        int i = 0;
        List<Integer> userList = new ArrayList<>();
        for (Integer u:users) {
            if (!(userList.contains(u))){
                userList.add(u);
                System.out.println("User #"+ (i+1) +" id: " + u);
                i++;
            }
        }
    }
    public void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
//        FlightService flight = new FlightService();
        System.out.println("\nDeleting flight\n");
        try {
            System.out.println("Enter the flight id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight2 = flight.findById(find);
        if (flight2.isPresent()){
            Flight fdelete = flight2.get();
            flight.delete(fdelete);
            System.out.println("Deleted flight with id " + fdelete.getId());
        }
        else
            System.out.println("This flight doesnt exist");
    }
    public Flight setter(Flight f1, String origin, String air, String dest){
        f1.setOrigin(origin);
        f1.setDestination(dest);
        f1.setAirline(air);
        flight.save(f1);
        return f1;
    }
}
