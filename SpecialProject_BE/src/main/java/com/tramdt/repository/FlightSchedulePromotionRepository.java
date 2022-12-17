package com.tramdt.repository;

import com.tramdt.model.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightSchedulePromotionRepository extends JpaRepository<FlightSchedule, Long> {

    @Query( value = "SELECT * FROM flightticket.promo \n" +
            "inner join  flightticket.branches ON promo.airline = branches.branch_id \n" +
            "inner join flightticket.flight_schedules ON branches.branch_id = flight_schedules.branch_id \n" +
            "where flightticket.promo.promo_date_end >= now() and flightticket.promo.promo_date_start <= now() \n" +
            "and flightticket.flight_schedules.arrival_time between flightticket. promo.flight_departure_date_start AND flightticket.promo.flight_departure_date_end \n" +
            "and arrival_airport_id = arrival_place and departure_airport_id = departure_place and flight_schedules.status = 'active' and departure_airport_id = ?1 and arrival_airport_id = ?2 and arrival_time >= ?3 and  arrival_time <= ?4"
             ,nativeQuery = true

    )


    List<FlightSchedule> findAllFlightSchedulesPromotion(Long depCode, Long arrCode, LocalDateTime from, LocalDateTime to);

    @Query( value = "SELECT * FROM flightticket.flight_schedules " +
            "inner join  flightticket.branches ON flight_schedules.branch_id = branches.branch_id " +
            "inner join flightticket.promo ON promo.airline = branches.branch_id " +
            "where flightticket.promo.promo_date_end >= now() and flightticket.promo.promo_date_start <= now() " +
            "and flightticket.flight_schedules.arrival_time between flightticket. promo.flight_departure_date_start AND flightticket.promo.flight_departure_date_end " +
            "and arrival_airport_id = arrival_place and departure_airport_id = departure_place and flight_schedules.status = 'active' and arrival_time >= ?1 and  arrival_time <= ?2"
            ,nativeQuery = true
    )
    List<FlightSchedule> listFlightSchedulesPromotion(LocalDateTime from , LocalDateTime to);

}
