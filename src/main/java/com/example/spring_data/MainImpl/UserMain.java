package com.example.spring_data.MainImpl;

import com.example.spring_data.Repository.UserRepository.UserRepository;
import com.example.spring_data.model.Booking;
import com.example.spring_data.model.Flight;
import com.example.spring_data.model.User;
import com.example.spring_data.model.UserDetails;
import com.example.spring_data.services.BookingService;
import com.example.spring_data.services.Impl.UserServiceImpl;
import com.example.spring_data.services.UserDetailsService;
import com.example.spring_data.services.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class UserMain {
    UserService user;
    UserDetailsMain UserDetailsMain;
    BookingService bookingService;
    UserDetailsService userDetailsService;
    public UserMain(UserServiceImpl user, UserDetailsMain userDetailsMain, BookingService bookingService, UserDetailsService userDetailsService) {
        this.user = user;
        this.UserDetailsMain = userDetailsMain;
        this.bookingService = bookingService;
        this.userDetailsService = userDetailsService;
    }

    public void find(){
//        UserService user = new UserService();
        List<User> userList = user.findAll();
        if (userList.isEmpty()){
            System.out.println("No users yet");
            return;
        }
        System.out.println("All the users...\n");
        for (User us : userList) {
            System.out.println(user.converter(us));
        }
    }
    public User add(){
        Scanner read = new Scanner(System.in);
//        UserService user = new UserService();
        Integer id = 0;
        System.out.println("\nAdding user\n");
        System.out.println("Enter the user id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the username");
        String name = read.nextLine();
        System.out.println("Enter the user password");
        String pass = read.nextLine();
        System.out.println("Enter the user role");
        String role = read.nextLine();
        Optional<User> userById = user.findById(id);
        if (userById.isPresent()){
            User u1 = userById.get();
            u1=setter(u1,name,role,pass);
            System.out.println("Updated user with id " + u1.getId());
            return u1;
        }
        else {
            User u2 = new User();
            u2.setId(null);
            u2=setter(u2,name,role,pass);
            System.out.println("Added user with id " + u2.getId());
            return u2;
        }
    }
    public void findId(){
        Scanner read = new Scanner(System.in);
//        UserService user = new UserService();
        Integer find = 0;
        System.out.println("\nFinding user by id\n");
        try {
            System.out.println("Enter the user id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user1 = user.findById(find);
        if (user1.isPresent()){
            User byId = user1.get();
            System.out.println(user.converter(byId));
        }
        else
            System.out.println("This user doesnt exist");
    }
    public void findByRole(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the role you want to query");
        String role = read.nextLine();
        List<User> userList = user.findAllByRoleContains(role);
        if (userList.isEmpty()){
            System.out.println("No user has this role");
            return;
        }
        System.out.println("All the users with the role " + role + "...\n");
        for (User us : userList) {
            System.out.println(user.converter(us));
        }
    }
    public void findByBooking(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the booking id you want to query");
        Integer bId = 0;
        try {
            bId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<Booking> booking = bookingService.findById(bId);
        if (!(booking.isPresent())){
            System.out.println("This booking doesnt exist");
            return;
        }
        Booking b1 = booking.get();
        List<User> userList = user.findAllByBookings(b1);
        if (userList.isEmpty()){
            System.out.println("No user has booked this booking");
            return;
        }
        System.out.println("All the users who booked the booking with id " + bId + "...\n");
        for (User us : userList) {
            System.out.println(user.converter(us));
        }
    }
    public void findByUsername(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the username you want to query");
        String username = read.nextLine();
        List<User> userList = user.findAllByUserName(username);
        if (userList.isEmpty()){
            System.out.println("No users have this username");
            return;
        }
        System.out.println("All the users with username " + username + "...\n");
        for (User us : userList) {
            System.out.println(user.converter(us));
        }
    }
    public void findByFirstName(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the first name you want to query");
        String fname = read.nextLine();
        List<UserDetails> ud = userDetailsService.findFirstByFirstName(fname);
        if (ud.isEmpty()){
            System.out.println("No user with the name "+fname);
            return;
        }
        System.out.println("All the users with the name " + fname + "...\n");
        for (UserDetails u:ud) {
            User us = user.findAllByUserDetails(u);
            System.out.println(user.converter(us));
        }
    }
    public void findByEmail(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the email you want to query");
        String email = read.nextLine();
        List<UserDetails> ud = userDetailsService.findFirstByEmail(email);
        if (ud.isEmpty()){
            System.out.println("No user with the email "+email);
            return;
        }
        System.out.println("All the users with the email " + email + "...\n");
        for (UserDetails u:ud){
            User us = user.findAllByUserDetails(u);
            System.out.println(user.converter(us));
        }
    }
    public void findByPhoneNumber(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the phone number you want to query");
        String phone = read.nextLine();
        List<UserDetails> ud = userDetailsService.findFirstByPhoneNumber(phone);
        if (ud.isEmpty()){
            System.out.println("No user with the phone number "+phone);
            return;
        }
        System.out.println("All the users with the phone number " + phone + "...\n");
        for (UserDetails u:ud){
            User us = user.findAllByUserDetails(u);
            System.out.println(user.converter(us));
        }
    }
    public void findAllBookings(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the user id from which you want to get the bookings");
        Integer uId = 0;
        try {
            uId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<User> u1 = user.findById(uId);
        if (!(u1.isPresent())){
            System.out.println("This user doesnt exist");
            return;
        }
        User user1 = u1.get();
        List<Integer> bookings = user.findAllBookings(uId);
        if (bookings.isEmpty()){
            System.out.println("This user hasnt booked any bookings");
            return;
        }
        System.out.println("All the booking id-s of this user\n");
        int i = 0;
        for (Integer b:bookings) {
            System.out.println("Booking #"+ (i+1) +" id: " + b);
            i++;
        }
    }
    public void findAllFlights(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the user id from which you want to get the flights");
        int uId = 0;
        try {
            uId = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        Optional<User> u1 = user.findById(uId);
        if (!(u1.isPresent())){
            System.out.println("This user doesnt exist");
            return;
        }
        User user1 = u1.get();
        List<Integer> bookings = user.findAllBookings(uId);
        if (bookings.isEmpty()){
            System.out.println("This user has no flights");
            return;
        }
        int i = 1;
        System.out.println("Flight id-s of this user\n");
        for (Integer b:bookings) {
            List<Integer> flights = user.findAllFlights(b);
            System.out.println("Booking #" + i + ":");
            int j = 1;
            for (Integer f:flights) {
                System.out.println("Flight #"+ (j) +" id: " + f);
                j++;
            }
            i++;
        }
    }
    public void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
//        UserService user = new UserService();
        System.out.println("\nDeleting user\n");
        try {
            System.out.println("Enter the user id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user2 = user.findById(find);
        if (user2.isPresent()){
            User udelete = user2.get();
            user.delete(udelete);
            System.out.println("Deleted user with id " + udelete.getId());
        }
        else
            System.out.println("This user doesnt exist");
    }
    public User setter(User u1, String name, String role, String pass){
        u1.setUserName(name);
        u1.setRole(role);
        u1.setPassword(pass);
        user.save(u1);
        UserDetails ud = UserDetailsMain.add(u1);
        u1.setUserDetails(ud);
        return u1;
    }
}
