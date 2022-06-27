package com.example.spring_data;
import com.example.spring_data.MainImpl.BookingMain;
import com.example.spring_data.MainImpl.FlightMain;
import com.example.spring_data.MainImpl.UserMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Scanner;
@SpringBootApplication
public class SpringDataApplication {
    UserMain UserMain;
    BookingMain BookingMain;
    FlightMain FlightMain;
    @Autowired
    public SpringDataApplication(UserMain userMain, BookingMain bookingMain, FlightMain flightMain) {
        this.UserMain = userMain;
        this.BookingMain = bookingMain;
        this.FlightMain = flightMain;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }
    @PostConstruct
    private void run(){
        Scanner read = new Scanner(System.in);
        String menu = "";
        String result="";
        while (!(menu.equalsIgnoreCase("E"))){
            System.out.println("Choose the menu\n1.Menu User\n2.Menu Flights\n3.Menu Bookings\nPress E to exit");
            menu=read.nextLine();
            if (menu.equalsIgnoreCase("1")){
                result="";
                while (!(result.equalsIgnoreCase("13"))){
                    System.out.println("\nMenu User\n1.Save User\n2.Find user by id\n3.Find all users\n4.Delete a user\n5.Find user by role\n6.Find user by Booking\n7.Find user by Username\n8.Find user by Email\n9.Find user by first name\n10.Find user by Phone number\n11.Find all bookings of a user\n12.Find all flights of a user\n13.Exit User Menu\nChoose an option (1-12)");
                    result = read.nextLine();
                    switch (result){
                        case "1":   UserMain.add();
                            break;

                        case "2":   UserMain.findId();
                            break;

                        case "3":   UserMain.find();
                            break;

                        case "4":   UserMain.remove();
                            break;

                        case "5":   UserMain.findByRole();
                            break;

                        case "6":   UserMain.findByBooking();
                            break;

                        case "7":   UserMain.findByUsername();
                            break;

                        case "8":   UserMain.findByEmail();
                            break;

                        case "9":   UserMain.findByFirstName();
                            break;

                        case "10":   UserMain.findByPhoneNumber();
                            break;

                        case "11":   UserMain.findAllBookings();
                            break;

                        case "12":   UserMain.findAllFlights();
                            break;

                        case "13":   break;

                        default:    System.out.println("Wrong option!");
                            break;
                    }
                }
            }
            else if (menu.equalsIgnoreCase("2")){
                result = "";
                while (!(result.equalsIgnoreCase("7"))){
                    System.out.println("\nMenu Flights\n1.Save Flight\n2.Find flight by id\n3.Find all flights\n4.Delete a flight\n5.Find all bookings of a flight\n6.Find all users of a flight\n7.Exit Flight Menu\nChoose an option (1-7)");
                    result = read.nextLine();
                    switch (result){
                        case "1":   FlightMain.add();
                            break;

                        case "2":   FlightMain.findId();
                            break;

                        case "3":   FlightMain.find();
                            break;

                        case "4":   FlightMain.remove();
                            break;

                        case "5":   FlightMain.findAllBookings();
                            break;

                        case "6":   FlightMain.findAllUsers();
                            break;

                        case  "7":  break;

                        default:    System.out.println("Wrong option!");
                            break;
                    }
                }
            }
            else if (menu.equalsIgnoreCase("3")){
                result = "";
//                BookingMain BookingMain = new BookingMain();
                while (!(result.equalsIgnoreCase("6"))){
                    System.out.println("\nMenu Booking\n1.Save Booking\n2.Find booking by id\n3.Find all bookings\n4.Delete a booking\n5.Find all flights of a booking\n6.Exit Bookings Menu\nChoose an option (1-6)");
                    result = read.nextLine();
                    switch (result){
                        case "1":   BookingMain.add();
                            break;

                        case "2":   BookingMain.findId();
                            break;

                        case "3":   BookingMain.find();
                            break;

                        case "4":   BookingMain.remove();
                            break;

                        case "5":   BookingMain.findAllFlights();
                            break;

                        case  "6":  break;

                        default:    System.out.println("Wrong option!");
                            break;

                    }
                }
            }
            else if (!(menu.equalsIgnoreCase("E")))
                System.out.println("Wrong option");
        }
    }
}
