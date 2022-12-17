package com.tramdt.service;

import com.tramdt.dto.PassengerCheckinDto;
import com.tramdt.dto.PassengerDTO;
import com.tramdt.dto.PassengerInfoDTO;
import com.tramdt.model.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import java.time.LocalDate;
import java.util.List;


public interface PassengerService {

    Page<PassengerCheckinDto> findPassengerByCriteria(Specification<Passenger> spec, int page);


    Specification<Passenger> getFilter(String fullName, String address);


    Page<PassengerCheckinDto> findAllPassengerCheckin(int page);

    Passenger saveAndUpdate(PassengerInfoDTO _passenger);


    List<Passenger> addAllPassengers(List<PassengerInfoDTO> passengerInfoDtoList);


    Page<Passenger> getAllCustomer(Pageable page);


    void checkinPassenger(Passenger passenger);

    Passenger findById(Long id);

    Page<Passenger> findByEmail(String email, Pageable pageable);

    Page<Passenger> findAllByFullName(String name, Pageable pageable);

    Page<Passenger> findAllByBirthday(LocalDate date, Pageable pageable);

    Page<Passenger> findByPhoneNumber(String phoneNumber, Pageable pageable);

    Page<Passenger> findAllByGender(String gender, Pageable pageable);


    void savePassenger(Passenger passenger);

    PassengerDTO findPassengerDtoByUserId(Long id);

    Passenger findPassengerById(Long id);

    void updatePassenger(PassengerDTO passengerDTO, Long id);

    Passenger create(PassengerDTO passengerDTO);

    Integer finByIdCard(String idCard);

    Integer finByEmail(String email);

    Integer finByPhone(String phone);
}


