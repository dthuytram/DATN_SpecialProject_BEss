package com.tramdt.repository;

import com.tramdt.dto.ReportAirline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportAirlineRepository  extends JpaRepository<ReportAirline, Long> {
    @Query(value = "CALL find_total_airline(?1, ?2);", nativeQuery = true)
    List<ReportAirline> findTotalAirlinePerDate(LocalDateTime date1, LocalDateTime date2);
}
