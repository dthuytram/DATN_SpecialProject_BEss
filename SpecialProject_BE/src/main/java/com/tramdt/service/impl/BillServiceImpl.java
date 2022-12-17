package com.tramdt.service.impl;

import com.tramdt.dto.SelectDto;
import com.tramdt.model.Airport;
import com.tramdt.model.Bill;
import com.tramdt.model.Branch;
import com.tramdt.repository.AirportRepository;
import com.tramdt.repository.BillRepository;
import com.tramdt.repository.BrandRepository;
import com.tramdt.service.BillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    AirportRepository airportRepository;
    @Autowired
    BrandRepository brandRepository;
    Sort sort = Sort.by(Sort.Direction.ASC, "dateCreated");
    Pageable pageable = PageRequest.of(0,2, sort);

    @Override
    public Page<Bill> getBillsByAccountId(Long accountId, int currentPage) {
        if(currentPage > 0 ) {
            Pageable pageable = PageRequest.of(--currentPage, 4, sort);
            return billRepository.findByTransaction_Account_Id(accountId, pageable);
        }
        return billRepository.findByTransaction_Account_Id(accountId, pageable);
    }
    @Override
    public Page<Bill> getSearchedBills(Long accountId, String billCode, String brand, String departure, String arrival, int page) {
        Specification<Bill> bills = new Specification<Bill>() {
            @Override
            public Predicate toPredicate(Root<Bill> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();

                list.add(criteriaBuilder.equal(root.get("transaction").get("account").get("id"), accountId));
                if(StringUtils.isNotBlank(billCode)){
                    list.add(criteriaBuilder.equal(root.get("billCode").as(String.class), billCode));
                }
                if(StringUtils.isNotBlank(brand)){
                    list.add(criteriaBuilder.equal(root.get("transaction").get("flightSchedule").get("branch").get("name"), brand));
                }
                if(StringUtils.isNotBlank(departure)){
                    list.add(criteriaBuilder.equal(root.get("transaction").get("flightSchedule").get("departureAirport").get("name"), departure));
                }
                if(StringUtils.isNotBlank(arrival)){
                    list.add(criteriaBuilder.equal(root.get("transaction").get("flightSchedule").get("departureAirport").get("name"), arrival));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        if(page> 0){
            Pageable pageable = PageRequest.of(--page, 2, sort);
            return billRepository.findAll(bills, pageable);
        }
        return billRepository.findAll(bills, pageable);
    }
    @Override
    public SelectDto getSelectDto() {
        List<Airport> airports = airportRepository.findAll();
        List<Branch> branchList = brandRepository.findAll();
        return new SelectDto(airports,branchList);

}

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(RuntimeException::new);
    }



    @Override
    public Page<Bill> findAllBills(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Page<Bill> findBillByBillsCode(Pageable pageable, String billCode) {
        return billRepository.findBillsByBillCode(pageable,billCode);
    }

    @Override
    public Page<Bill> searchBills(String billCode, String billTax, String name, Pageable pageable) {
        if(billCode.equals("") && billTax.equals("")){
            return billRepository.findByTransaction_Account_FullNameContaining(name,pageable);
        } else if (billCode.equals("") && name.equals("")){
            return billRepository.findByTaxCodeIs(billTax,pageable);
        } else if (billTax.equals("") && name.equals("")) {
            return billRepository.findByBillCodeIs(billCode,pageable);
        } else if (!billCode.equals("") && !billTax.equals("")){
            return  billRepository.findByBillCodeIsAndTaxCodeIsOrTransaction_Account_FullNameContaining(billCode,billTax,name,pageable);
        } else if (!billCode.equals("")) {
            return billRepository.findByBillCodeIsAndTaxCodeIsAndTransaction_Account_FullNameContaining(billCode,billTax,name,pageable);
        }
        return billRepository.findByBillCodeIsOrTaxCodeIsOrTransaction_Account_FullNameContaining(billCode,billTax,name,pageable);
    }
}
