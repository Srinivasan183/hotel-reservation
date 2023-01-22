package com.hotel.reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    private Integer id;

    private String clientFullName;

    private Integer roomNumber;

    private List<LocalDate> reservationDates;


}
