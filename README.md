# hotel-reservation

Swagger UI - http://localhost:8083/swagger-ui.html

Get - getAllReservations(),

Get - getReservationById(Integer id),

Post - reserveRoom(Reservation res)

    request
    {
      "id" = 1,
      "clientFullName" = "Srinivasan Elayaperumal",
      "reservationDates" = ["2022-12-12"],
      "roomNumber" = 1
    }
    
Put - updateReservedRoom(Reservation res)

    request
    {
      "id" = 1,
      "clientFullName" = "David Beckham",
      "reservationDates" = ["2022-12-12"],
      "roomNumber" = 2
    }
