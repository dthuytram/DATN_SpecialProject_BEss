package com.tramdt.service;

import com.tramdt.dto.*;
import com.tramdt.model.Account;
import org.springframework.security.core.userdetails.UserDetails;


public  interface AccountService {

    boolean existsEmail(String email);

    Account findByEmail(String email);

    Account saveAccount(Account account);

    UserDetails getUserDetail(Account account);

    Account getProfileGoogle(TokenDto tokenDto);

    Account getProfileFacebook(TokenDto tokenDto);

    Account findAccountByEmail(String email);

    Account findAccountById(Long id) ;

     CustomerUpdateDTO findCustomerUpdateDTOById(Long id) ;

     void updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    void changePassword(CustomerChangePasswordDTO customerChangePasswordDTO);

     Account autoRegAccount(Account account);

    employeeInfoDto findEmployeeInfoDtoById(Long id);

    Account findEmployeeById(Long id);

    void changePassword(employeeInfoDto employeeInfoDto);

    void saveEmployee(Account employeeDelete);

    void editEmployee(AccountDTO employeeEditDto, Long id);

    AccountDTO findEmployeeDtoById(Long id);

    void deleteEmployee(Account employeeDelete);

    Boolean existAccountByEmail(String email);
    Boolean existAccountByPhone(String phone);
//    Boolean existAccountByIdCard(String idCard);

    void save(Account acc);
}

