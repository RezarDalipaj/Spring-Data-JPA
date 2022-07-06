package com.example.springData;

import com.example.springData.mainImpl.BookingMain;
import com.example.springData.mainImpl.FlightMain;
import com.example.springData.mainImpl.UserMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication {
    UserMain userMain;
    BookingMain bookingMain;
    FlightMain flightMain;

    @Autowired
    public SpringDataApplication(UserMain userMain, BookingMain bookingMain, FlightMain flightMain) {
        this.userMain = userMain;
        this.bookingMain = bookingMain;
        this.flightMain = flightMain;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @PostConstruct
    private void run() {
        Scanner read = new Scanner(System.in);
        String menu = "";
        String result = "";
        while (!(menu.equalsIgnoreCase("E"))) {
            System.out.println("Choose the menu\n1.Menu User\n2.Menu Flights\n3.Menu Bookings\nPress E to exit");
            menu = read.nextLine();
            if (menu.equalsIgnoreCase("1")) {
                result = "";
                while (!(result.equalsIgnoreCase("13"))) {
                    System.out.println("\nMenu User\n1.Save User\n2.Find user by id\n3.Find all users\n4.Delete a user\n5.Find user by role\n6.Find user by Booking\n7.Find user by Username\n8.Find user by Email\n9.Find user by first name\n10.Find user by Phone number\n11.Find all bookings of a user\n12.Find all flights of a user\n13.Exit User Menu\nChoose an option (1-12)");
                    result = read.nextLine();
                    switch (result) {
                        case "1":
                            userMain.add();
                            break;

                        case "2":
                            userMain.findId();
                            break;

                        case "3":
                            userMain.find();
                            break;

                        case "4":
                            userMain.remove();
                            break;

                        case "5":
                            userMain.findByRole();
                            break;

                        case "6":
                            userMain.findByBooking();
                            break;

                        case "7":
                            userMain.findByUsername();
                            break;

                        case "8":
                            userMain.findByEmail();
                            break;

                        case "9":
                            userMain.findByFirstName();
                            break;

                        case "10":
                            userMain.findByPhoneNumber();
                            break;

                        case "11":
                            userMain.findAllBookings();
                            break;

                        case "12":
                            userMain.findAllFlights();
                            break;

                        case "13":
                            break;

                        default:
                            System.out.println("Wrong option!");
                            break;
                    }
                }
            } else if (menu.equalsIgnoreCase("2")) {
                result = "";
                while (!(result.equalsIgnoreCase("7"))) {
                    System.out.println("\nMenu Flights\n1.Save Flight\n2.Find flight by id\n3.Find all flights\n4.Delete a flight\n5.Find all bookings of a flight\n6.Find all users of a flight\n7.Exit Flight Menu\nChoose an option (1-7)");
                    result = read.nextLine();
                    switch (result) {
                        case "1":
                            flightMain.add();
                            break;

                        case "2":
                            flightMain.findId();
                            break;

                        case "3":
                            flightMain.find();
                            break;

                        case "4":
                            flightMain.remove();
                            break;

                        case "5":
                            flightMain.findAllBookings();
                            break;

                        case "6":
                            flightMain.findAllUsers();
                            break;

                        case "7":
                            break;

                        default:
                            System.out.println("Wrong option!");
                            break;
                    }
                }
            } else if (menu.equalsIgnoreCase("3")) {
                result = "";
//                BookingMain BookingMain = new BookingMain();
                while (!(result.equalsIgnoreCase("6"))) {
                    System.out.println("\nMenu Booking\n1.Save Booking\n2.Find booking by id\n3.Find all bookings\n4.Delete a booking\n5.Find all flights of a booking\n6.Exit Bookings Menu\nChoose an option (1-6)");
                    result = read.nextLine();
                    switch (result) {
                        case "1":
                            bookingMain.add();
                            break;

                        case "2":
                            bookingMain.findId();
                            break;

                        case "3":
                            bookingMain.find();
                            break;

                        case "4":
                            bookingMain.remove();
                            break;

                        case "5":
                            bookingMain.findAllFlights();
                            break;

                        case "6":
                            break;

                        default:
                            System.out.println("Wrong option!");
                            break;

                    }
                }
            } else if (!(menu.equalsIgnoreCase("E")))
                System.out.println("Wrong option");
        }
    }
}
