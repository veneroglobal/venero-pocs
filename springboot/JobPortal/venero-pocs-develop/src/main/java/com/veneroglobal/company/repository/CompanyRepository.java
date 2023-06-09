package com.veneroglobal.company.repository;

import com.veneroglobal.common.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
