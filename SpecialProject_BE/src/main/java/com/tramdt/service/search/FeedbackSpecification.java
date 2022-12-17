package com.tramdt.service.search;


import com.tramdt.model.Feedback;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class FeedbackSpecification implements Specification<Feedback> {

    private final SearchCriteria criteria;

    public FeedbackSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Feedback> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase("like")) {
            // value like %chuỗi_tìm_kiếm%
            return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValues().get(0) + "%");
        } else if (criteria.getOperation().equalsIgnoreCase("equal")) {
            Boolean _processStatus = Boolean.valueOf(criteria.getValues().get(0));
            return criteriaBuilder.equal(root.get(criteria.getKey()), _processStatus);
        } else if (criteria.getOperation().equalsIgnoreCase("equal")) {
            LocalDate _createDate = LocalDate.parse(criteria.getValues().get(0));
            System.out.println(_createDate instanceof LocalDate);
            return criteriaBuilder.equal(root.get(criteria.getKey()), _createDate);
        } else {
            return null;
        }




    }
}
