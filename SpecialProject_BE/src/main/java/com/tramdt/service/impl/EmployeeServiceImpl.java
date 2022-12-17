package com.tramdt.service.impl;

import com.tramdt.dto.AccountDTO;
import com.tramdt.dto.EmployeePassengerDTO;
import com.tramdt.dto.EmployeeTransactionDTO;
import com.tramdt.model.*;
import com.tramdt.repository.*;
import com.tramdt.service.EmployeeService;
import com.tramdt.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightScheduleRepository flightScheduleRepository;
    @Autowired
    TransactionDetailRepository transactionDetailRepository;
    @Autowired
    TransactionService transactionService;

    // luu ve
    @Override
    public List<Transaction> saveTransactionsAndTickets(List<EmployeeTransactionDTO> transactions, List<EmployeePassengerDTO> passengers) {
        List<Passenger> passengerList = new ArrayList<>();
        List<Transaction> transactionList = new ArrayList<>();
        for (EmployeePassengerDTO passengerDTO : passengers) {
            ModelMapper modelMapper = new ModelMapper();
            Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
            //Kiểm tra coi idCard đã tồn tại
            if (passengerDTO.getIdentifierCard() != null) {
                Passenger passengerSearch = passengerRepository.findByIdentifierCard(passengerDTO.getIdentifierCard());
                if (passengerSearch != null) {
                    passenger.setId(passengerSearch.getId());
                }
            }
            passengerRepository.save(passenger);
            passengerList.add(passenger);
        }
        for (int k = 0; k < transactions.size(); k++) {
            Transaction transaction = new Transaction();
            transaction.setAccount(transactions.get(k).getAccount());
            transaction.setCreatedTime(transactions.get(k).getCreatedTime());
            transaction.setDueTime(transactions.get(k).getDueTime());
            transaction.setFlightSchedule(transactions.
                    get(k).getFlightSchedule());
            transaction.setPrice(transactions.get(k).getPrice());
            transaction.setStatus(transactions.get(k).getStatus());
            Transaction newTransaction = transactionService.save(transaction);
            transactionList.add(newTransaction);
            //update vào transaction_detail
            for (int i = 0; i < passengerList.size(); i++) {
                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransaction(transaction);
                transactionDetail.setPassenger(passengerList.get(i));
                if (k == 0) {
                    transactionDetail.setBaggage(getLuggageWeight(passengers.get(i).getDeptLuggagePrice()));
                } else {
                    transactionDetail.setBaggage(getLuggageWeight(passengers.get(i).getArvLuggagePrice()));
                }
                transactionDetailRepository.save(transactionDetail);
            }

            //update lai capacity flight
            FlightSchedule flightSchedule = flightScheduleRepository.findById(transactions.get(k).getFlightSchedule().getId()).orElse(null);
            if (flightSchedule != null) {
                flightSchedule.setFlightCapacity(flightSchedule.getFlightCapacity() - passengers.size());
                if (flightSchedule.getFlightCapacity() == 0) {
                    flightSchedule.setStatus("inactive");
                }
                flightScheduleRepository.save(flightSchedule);
            }
        }
        return transactionList;
    }


    @Override
    public Transaction findTransactionById(Long id) {
        return this.transactionRepository.findById(id).orElse(null);
    }

    // lấy kg hành lý
    private byte getLuggageWeight(int money) {
        switch (money) {
            case 170000:
                return 15;
            case 225000:
                return 20;
            case 275000:
                return 25;
            default:
                return 7;
        }
    }
    @Autowired
    private AccountRepository employeeRepository;

    @Override
    public List<Account> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Page<AccountDTO> findAllAccount(Pageable pageable) {
        Page<Account> accounts = employeeRepository.findAllByRoleAndStatus("ROLE_EMPLOYEE",true,pageable);
        return transferToDTO(accounts);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Account findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Page<AccountDTO> findAllByFullName(String name, Pageable pageable) {
        return transferToDTO(employeeRepository.findAllByFullNameAndRoleAndStatus(name,"ROLE_EMPLOYEE",true, pageable));
    }

    @Override
    public Page<AccountDTO> findAllByBirthday(LocalDate birthday, Pageable pageable) {
        return transferToDTO(employeeRepository.findAllByBirthDateAndRoleAndStatus(birthday,"ROLE_EMPLOYEE",true, pageable));
    }


    @Override
    public Page<AccountDTO> findAllByPhoneNumber(String phone, Pageable pageable) {
        return transferToDTO(employeeRepository.findAllByPhoneNumberAndRoleAndStatus(phone,"ROLE_EMPLOYEE",true, pageable));
    }

    @Override
    public Page<AccountDTO> findAllByGender(String address, Pageable pageable) {
        return transferToDTO(employeeRepository.findAllByAddressAndRoleAndStatus(address,"ROLE_EMPLOYEE",true, pageable));
    }


    @Override
    public Page<AccountDTO> findAllByEmail(String email, Pageable pageable) {
        return transferToDTO(employeeRepository.findAllByEmailAndRoleAndStatus(email,"ROLE_EMPLOYEE",true, pageable));
    }

    @Override
    public Boolean checkEmailAlready(String email) {
        Account account = employeeRepository.findByEmail(email);
        return account != null;
    }

    @Override
    public void save(Account account) {
        employeeRepository.save(account);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public AccountDTO coverAccountToEmpDTO(Account employee) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(employee.getId());
        accountDTO.setFullName(employee.getFullName());
        accountDTO.setBirthday(employee.getBirthDate());
        accountDTO.setAddress(employee.getAddress());
        accountDTO.setEmail(employee.getEmail());
        accountDTO.setPhoneNumber(employee.getPhoneNumber());
        accountDTO.setAvatarImageUrl(employee.getAvatarImageUrl());
        return accountDTO;
    }

    @Override
    public Account coverEmpDTOToAccount(AccountDTO accountDTO) {
        Account employee = new Account();
        employee.setId(accountDTO.getId());
        employee.setFullName(accountDTO.getFullName());
        employee.setBirthDate(accountDTO.getBirthday());
        employee.setAddress(accountDTO.getAddress());
        employee.setEmail(accountDTO.getEmail());
        employee.setPhoneNumber(accountDTO.getPhoneNumber());
        employee.setAvatarImageUrl(accountDTO.getAvatarImageUrl());
        return employee;
    }

    @Override
    public Page<AccountDTO> coverListAccountToListEmpDTO(Page<Account> accounts) {
        return null;
    }

    public Page<AccountDTO> transferToDTO(Page<Account> Accounts) {
        Iterator iterator = Accounts.iterator();
        List<AccountDTO> accountDTOList = new ArrayList<AccountDTO>();
        while (iterator.hasNext()) {
            Account account = (Account) iterator.next();
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(account.getId());
            accountDTO.setFullName(account.getFullName());
            accountDTO.setEmail(account.getEmail());
            accountDTO.setAddress(account.getAddress());
            accountDTO.setAvatarImageUrl(account.getAvatarImageUrl());
            accountDTO.setBirthday(account.getBirthDate());
            accountDTO.setPhoneNumber(account.getPhoneNumber());
            accountDTOList.add(accountDTO);
        }
        return new PageImpl<AccountDTO>(accountDTOList, Accounts.getPageable(), Accounts.getTotalElements());
    }


    @Override
    public List<Account> coverListEmpDTOToListAccount(List<AccountDTO> accountDTOList) {
        List<Account> accounts = new ArrayList<Account>();
        accountDTOList.forEach((n) -> accounts.add(coverEmpDTOToAccount(n)));
        return accounts;
    }


}
