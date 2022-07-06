package com.example.springData.mainImpl;

import com.example.springData.dto.UserDTO;
import com.example.springData.model.Booking;
import com.example.springData.model.User;
import com.example.springData.model.UserDetails;
import com.example.springData.service.BookingService;
import com.example.springData.service.UserDetailsService;
import com.example.springData.service.UserService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserMain {
    UserService userService;
    UserDetailsMain UserDetailsMain;
    BookingService bookingService;
    UserDetailsService userDetailsService;
    public UserMain(UserService userService, UserDetailsMain userDetailsMain, BookingService bookingService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.UserDetailsMain = userDetailsMain;
        this.bookingService = bookingService;
        this.userDetailsService = userDetailsService;
    }

    public void find(){
//        UserService user = new UserService();
        List<UserDTO> userList = userService.findAll();
        if (userList.isEmpty()){
            System.out.println("No users yet");
            return;
        }
        System.out.println("All the users...\n");
        for (UserDTO us : userList) {
            System.out.println(us);
        }
    }
    public UserDTO add(){
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
        User userById = userService.findById(id);
        if (userById != null){
            userById=setter(userById,name,role,pass);
            System.out.println("Updated user with username " + userById.getUserName());
            return userService.converter(userById);
        }
        else {
            User u2 = new User();
            u2.setId(null);
            u2=setter(u2,name,role,pass);
            System.out.println("Added user with id " + u2.getId());
            return userService.converter(u2);
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
        User user1 = userService.findById(find);
        if (user1!=null){
            System.out.println(userService.converter(user1));
        }
        else
            System.out.println("This user doesnt exist");
    }
    public void findByRole(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the role you want to query");
        String role = read.nextLine();
        List<UserDTO> userList = userService.findAllByRoleContains(role);
        if (userList.isEmpty()){
            System.out.println("No user has this role");
            return;
        }
        System.out.println("All the users with the role " + role + "...\n");
        for (UserDTO us : userList) {
            System.out.println(us);
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
        UserDTO us = userService.findUserByBookings(b1);
        System.out.println("The user who booked the booking with id " + bId + "...\n");
        System.out.println(us);
    }
    public void findByUsername(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the username you want to query");
        String username = read.nextLine();
        List<UserDTO> userList = userService.findAllByUserName(username);
        if (userList.isEmpty()){
            System.out.println("No users have this username");
            return;
        }
        System.out.println("All the users with username " + username + "...\n");
        for (UserDTO us : userList) {
            System.out.println(us);
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
            UserDTO us = userService.findAllByUserDetails(u);
            System.out.println(us);
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
            UserDTO us = userService.findAllByUserDetails(u);
            System.out.println(us);
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
            UserDTO us = userService.findAllByUserDetails(u);
            System.out.println(us);
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
        User user1 = userService.findById(uId);
        if (user1 == null){
            System.out.println("This user doesnt exist");
            return;
        }
        List<Integer> bookings = userService.findAllBookings(uId);
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
        User user1 = userService.findById(uId);
        if (user1 == null){
            System.out.println("This user doesnt exist");
            return;
        }
        List<Integer> bookings = userService.findAllBookings(uId);
        if (bookings.isEmpty()){
            System.out.println("This user has no flights");
            return;
        }
        int i = 1;
        System.out.println("Flight id-s of this user\n");
        for (Integer b:bookings) {
            List<Integer> flights = userService.findAllFlights(b);
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
        User user2 = userService.findById(find);
        if (user2!=null){
            userService.delete(user2);
            System.out.println("Deleted user with id " + user2.getId());
        }
        else
            System.out.println("This user doesnt exist");
    }
    public User setter(User u1, String name, String role, String pass){
        u1.setUserName(name);
        u1.setRole(role);
        u1.setPassword(pass);
        userService.save(u1);
        UserDetails ud = UserDetailsMain.add(u1);
        u1.setUserDetails(ud);
        return u1;
    }
}
