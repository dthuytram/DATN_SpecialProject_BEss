package com.tramdt.repository;

import com.tramdt.model.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;



@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long > , JpaSpecificationExecutor<Passenger> {


    Passenger findPassengerByIdentifierCard(String idCard);


    Passenger findByIdentifierCard(String identifyCard);
    @Query(value = "select * from passengers", nativeQuery = true)
    Page<Passenger> findAllCustomer(Pageable pageable);

    Page<Passenger> findAllByCheckinIsTrue(Pageable pageable);


    Page<Passenger> findAllByEmailContaining(String email,Pageable pageable);


    Page<Passenger> findAllByFullNameContaining(String name, Pageable pageable);


    Page<Passenger> findAllByBirthDate(LocalDate birthDate, Pageable pageable);

    Page<Passenger> findAllByPhoneNumberContaining(String phone, Pageable pageable);


    Page<Passenger> findAllByGenderContaining(String gender, Pageable pageable);

    @Query(value = "select count(identifier_card) from flightticket.passengers where identifier_card = ?", nativeQuery = true)
    Integer finByIdCard(String idCard);

    @Query(value = "select count(email) from flightticket.passengers where email = ?", nativeQuery = true)
    Integer finByEmail(String email);

    @Query(value = "select count(phone_number) from flightticket.passengers where phone_number = ?", nativeQuery = true)
    Integer finByPhone(String phone);
}
