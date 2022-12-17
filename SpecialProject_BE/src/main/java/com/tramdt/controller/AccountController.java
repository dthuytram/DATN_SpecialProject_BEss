package com.tramdt.controller;

import com.tramdt.dto.*;
import com.tramdt.model.Account;
import com.tramdt.model.SignForm;
import com.tramdt.security.userprinciple.secure.JwtTokenUtil;
import com.tramdt.service.AccountService;
import com.tramdt.service.PassengerService;
import com.tramdt.service.impl.UserDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountService accountService ;

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PassengerService passengerService;

    //Xem thông tin nhân viên
    @GetMapping("employee/{id}")
    public ResponseEntity<employeeInfoDto> findEmployeeById(@PathVariable Long id) {
        employeeInfoDto employeeInfoDto = accountService.findEmployeeInfoDtoById(id);
        if (employeeInfoDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(employeeInfoDto);
    }

    @PutMapping("employee/changePassword/{id}")
    public ResponseEntity<employeeInfoDto> changePassword(@PathVariable Long id, @RequestBody employeeInfoDto employeeInfoDto) {
        Account account = accountService.findEmployeeById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.changePassword(employeeInfoDto);
        return new ResponseEntity<>(employeeInfoDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
        );
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(authentication.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        Account accountLogin = accountService.findByEmail(userDetails.getUsername());
        JwtResponse a = new JwtResponse(jwtToken,accountLogin.getId(),accountLogin.getFullName(), userDetails.getUsername(), accountLogin.getAvatarImageUrl(),userDetails.getAuthorities());
        return ResponseEntity.ok(a);
    }

    @PostMapping("/google")
    public ResponseEntity<?> google(@RequestBody TokenDto tokenDto)  {
      Account accountGoogle ;

        if (accountService.existsEmail(tokenDto.getEmail())){
            accountGoogle = accountService.findByEmail(tokenDto.getEmail());
        }else{
            accountGoogle = accountService.getProfileGoogle(tokenDto);
            accountGoogle = accountService.saveAccount(accountGoogle);
        }
        UserDetails userDetails = accountService.getUserDetail(accountGoogle);
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken,accountGoogle.getId(),accountGoogle.getFullName(),userDetails.getUsername(),accountGoogle.getAvatarImageUrl(), userDetails.getAuthorities()));
    }


    @PostMapping("/facebook")
    public ResponseEntity<?> facebook(@RequestBody TokenDto tokenDto)  {
        Account accountFacebook ;
        if (accountService.existsEmail(tokenDto.getEmail())){
            accountFacebook = accountService.findByEmail(tokenDto.getEmail());
        }
        else{
            accountFacebook = accountService.getProfileFacebook(tokenDto);
            accountFacebook = accountService.saveAccount(accountFacebook);
        }

        UserDetails userDetails = accountService.getUserDetail(accountFacebook);
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken,accountFacebook.getId(),accountFacebook.getFullName(), userDetails.getUsername(), accountFacebook.getAvatarImageUrl(),userDetails.getAuthorities()));
    }

    //    Tìm khách hàng theo Id
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerUpdateDTO> findCustomerById(@PathVariable Long id) {
        CustomerUpdateDTO customerUpdateDTO = accountService.findCustomerUpdateDTOById(id);
        if (customerUpdateDTO == null) {
            return new ResponseEntity<CustomerUpdateDTO>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(customerUpdateDTO);
    }

    //  Chỉnh sửa thông tin khách hàng
    @PutMapping("customer/update/{id}")
    public ResponseEntity<CustomerUpdateDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<CustomerUpdateDTO>(HttpStatus.NOT_FOUND);
        }
        accountService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<CustomerUpdateDTO>(customerUpdateDTO, HttpStatus.OK);
    }

    /**
     * Thay đổi mật khẩu dành cho khách hàng
     *
     * @param id
     * @param customerChangePasswordDTO
     * @return
     */
    @PutMapping("customer/changepass/{id}")
    public ResponseEntity<CustomerChangePasswordDTO> CustomerChangePassword(@PathVariable Long id, @RequestBody CustomerChangePasswordDTO customerChangePasswordDTO) {
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<CustomerChangePasswordDTO>(HttpStatus.NOT_FOUND);
        }
        accountService.changePassword(customerChangePasswordDTO);
        return new ResponseEntity<CustomerChangePasswordDTO>(customerChangePasswordDTO, HttpStatus.OK);
    }

    /**
     * Đăng ký user mới
     *
     */
    @PostMapping(value = "/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignForm signForm) {
        PassengerInfoDTO customerDto = new PassengerInfoDTO();
        System.out.println("sign up");
        if (accountService.existAccountByPhone(signForm.getPhone())) {
            return new ResponseEntity<>("duplicate phone", HttpStatus.BAD_REQUEST);
        }
//        if (accountService.existAccountByIdCard(signForm.getIdCard())) {
//            return new ResponseEntity<>("duplicate idCard", HttpStatus.BAD_REQUEST);
//        }
        if (accountService.existAccountByEmail(signForm.getEmail())) {
            return new ResponseEntity<>("duplicate email", HttpStatus.BAD_REQUEST);
        }
        Account acc = new Account();
        acc.setRole("ROLE_USER");
        BeanUtils.copyProperties(signForm, acc);
        acc.setPassword(passwordEncoder.encode(signForm.getPassword()));
        System.out.println("Pass: " + passwordEncoder.encode(signForm.getPassword()));

        customerDto.setFullName(acc.getFullName());
        customerDto.setPhoneNumber(acc.getPhoneNumber());
        customerDto.setGender(acc.getGender());
        customerDto.setEmail(acc.getEmail());
        customerDto.setStatus(true);
        passengerService.saveAndUpdate(customerDto);
        accountService.save(acc);
        return new ResponseEntity<>(acc, HttpStatus.CREATED);
    }

}
