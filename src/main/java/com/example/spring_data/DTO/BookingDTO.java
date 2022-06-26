package com.example.spring_data.DTO;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
@Component
public class BookingDTO {
    private String userName;
    private String status;
    private Date bookingDate;
    private List<FlightDTO> flights;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                ", bookingDate=" + bookingDate +
                ", flights=" + flights +
                '}';
    }
}
