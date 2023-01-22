package com.hotel.reservation.service;

import com.hotel.reservation.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> getAllReservation();

    Reservation reserveRoom(Reservation reservation);

    Optional<Reservation> getReservedRoomById(int reservationId);

    Reservation updateReservedRoom(Reservation reservation);
}
