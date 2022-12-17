package com.tramdt.service;

import com.tramdt.dto.AccountDTO;
import com.tramdt.dto.EmployeePassengerDTO;
import com.tramdt.dto.EmployeeTransactionDTO;
import com.tramdt.model.Account;
import com.tramdt.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    // luu trans và pass
    List<Transaction> saveTransactionsAndTickets(List<EmployeeTransactionDTO> transactions, List<EmployeePassengerDTO> passengers);

    // find trans By Id
    Transaction findTransactionById(Long id);
    List<Account> findAll();

    Page<AccountDTO> findAllAccount(Pageable pageable);

    Optional<Account> findById(Long id);

    Account findByEmail(String email);

    Page<AccountDTO> findAllByFullName(String name, Pageable pageable);

    Page<AccountDTO> findAllByBirthday(LocalDate birthday, Pageable pageable);

    Page<AccountDTO> findAllByPhoneNumber(String phone, Pageable pageable);

    public Page<AccountDTO> findAllByGender(String gender, Pageable pageable);

    public Page<AccountDTO> findAllByEmail(String gender, Pageable pageable);

    Boolean checkEmailAlready(String email);

    void save(Account account);

    void remove(Long id);

    AccountDTO coverAccountToEmpDTO(Account account);

    Account coverEmpDTOToAccount(AccountDTO accountDTO);


    Page<AccountDTO> coverListAccountToListEmpDTO(Page<Account> accounts);

    List<Account> coverListEmpDTOToListAccount(List<AccountDTO> accountDTOList);


}
