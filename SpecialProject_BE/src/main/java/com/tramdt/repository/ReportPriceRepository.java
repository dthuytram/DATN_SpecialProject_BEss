package com.tramdt.repository;

import com.tramdt.dto.ReportPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportPriceRepository extends JpaRepository<ReportPrice, Long> {
        //Thành
        @Query(value = "CALL find_total_price(?1, ?2, ?3, ?4);", nativeQuery = true)
        List<ReportPrice> findTotalPricePerDate(LocalDateTime date1, LocalDateTime date2,LocalDateTime date3, LocalDateTime date4);
}
