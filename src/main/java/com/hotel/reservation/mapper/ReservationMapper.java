package com.hotel.reservation.mapper;


import com.hotel.reservation.dto.request.ReservationRequest;
import com.hotel.reservation.dto.response.ReservationResponse;
import com.hotel.reservation.entity.Reservation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReservationMapper {

    ReservationResponse mapRequest(Reservation reservation);

    List<ReservationResponse> mapRequests(List<Reservation> reservation);

    Reservation mapEntity(ReservationRequest reservation);

}
