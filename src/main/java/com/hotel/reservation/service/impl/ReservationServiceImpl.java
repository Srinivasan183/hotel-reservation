package com.hotel.reservation.service.impl;

import com.hotel.reservation.entity.Reservation;
import com.hotel.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

    private final Set<Reservation> reservations = new HashSet<>();

    @Override
    public List<Reservation> getAllReservation() {
        return new ArrayList<>(this.reservations);
    }

    @Override
    public Reservation reserveRoom(Reservation reservation) {
        Optional<Reservation> existingReservation = this.reservations.stream()
                .filter(allReservation -> allReservation.getRoomNumber().equals(reservation.getRoomNumber()))
                .findAny();
        if (existingReservation.isPresent() || this.reservations.contains(reservation)) {
            throw new RuntimeException("RoomNumber or Id are already existing");
        }
        this.reservations.add(reservation);
        return this.reservations.stream()
                .filter(allReservation -> allReservation.getId().equals(reservation.getId()))
                .findAny().orElseThrow(() -> new RuntimeException("Reservation not saved"));
    }

    @Override
    public Optional<Reservation> getReservedRoomById(int reservationId) {
        return this.reservations.stream()
                .filter(allReservation -> allReservation.getId().equals(reservationId))
                .findAny();
    }

    @Override
    public Reservation updateReservedRoom(Reservation reservation) {
        Optional<Reservation> existingReservation = this.reservations.stream()
                .filter(allReservation -> allReservation.getId().equals(reservation.getId()))
                .findAny();
        if (existingReservation.isPresent()) {
            this.reservations.removeIf(allReservation -> allReservation.getId().equals(reservation.getId()));
            this.reservations.add(reservation);
            return reservation;
        }
        throw new RuntimeException("No existing reservation for " + reservation.getClientFullName());
    }
}
