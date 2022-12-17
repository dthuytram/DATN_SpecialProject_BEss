package com.tramdt.service;

import com.tramdt.model.Promo;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
public interface PromoService {

    public void createNewPromo(Promo promo);

    public List<Promo> getPromoRunningNow(Pageable pageable);

    public List<Promo> getPromoExpired(Pageable pageable);

    public List<Promo> getPromoNotActive(Pageable pageable);

    public LocalDateTime convertDate(String date);

    Promo findById(Long id);

    void save(Promo promo);

    void delete(Promo promo);
}

