package com.tramdt.repository;

import com.tramdt.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByEmailAndStatusIsTrue(String email);


    boolean existsAccountByEmailAndStatusTrue(String email);

    public Account findByEmail(String email);


    public Page<Account> findAllByFullNameAndRoleAndStatus(String name,String role,Boolean status, Pageable pageable);


    public Page<Account> findAllByEmailAndRoleAndStatus(String email,String role,Boolean status, Pageable pageable);


    public Page<Account> findAllByBirthDateAndRoleAndStatus(LocalDate birthday,String role,Boolean status, Pageable pageable);


    public Page<Account> findAllByPhoneNumberAndRoleAndStatus(String phone_number,String role,Boolean status, Pageable pageable);


    public Page<Account> findAllByAddressAndRoleAndStatus(String gender,String role,Boolean status, Pageable pageable);


    public Page<Account> findAllByRoleAndStatus(String role,Boolean status, Pageable pageable);

    @Query(value = "SELECT * FROM accounts WHERE email =?",nativeQuery = true)
    Optional<Account> findAccountByEmail(String email);
    @Modifying
    @Query(value = "INSERT INTO accounts (`address`, `birth_date`,  `email`, `full_name`, `gender`,  `phone_number`,`password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",nativeQuery = true)
    void saveAccount(String address, String birthday,  String email, String full_name, boolean gender,  String phone, String password);

//    @Query(value = "SELECT id,address, birth_date, confirm_password, email, full_name, gender," +
//            "password, phone, country_id FROM accounts WHERE id_card =?",nativeQuery = true)
//    Optional<Account> findAccountByIdCard(String idCard);

    @Query(value = "SELECT * FROM accounts WHERE phone_number =?",nativeQuery = true)
    Optional<Account> findAccountByPhone(String phone);

}
