package com.tramdt.repository;

import com.tramdt.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Branch, Long> {
}
