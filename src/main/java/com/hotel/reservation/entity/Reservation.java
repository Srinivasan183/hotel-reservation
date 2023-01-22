package com.hotel.reservation.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Reservation {

    private Integer id;

    private String clientFullName;

    private Integer roomNumber;

    private List<LocalDate> reservationDates;
}
