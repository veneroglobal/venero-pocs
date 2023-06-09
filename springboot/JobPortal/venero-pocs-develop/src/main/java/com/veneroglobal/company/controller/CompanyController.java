package com.veneroglobal.company.controller;

import com.veneroglobal.common.entity.Company;
import com.veneroglobal.common.dto.CompanyRequest;

import com.veneroglobal.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @PostMapping("/company")
    public ResponseEntity<?> saveCompany(@RequestBody CompanyRequest companyRequest) {
        this.companyService.savedCompany(companyRequest);
        return ResponseEntity.ok(companyRequest);
    }

    @GetMapping("/company")
    public ResponseEntity<?> fetchAllCompany() {
        List<Company> allCompanyList = this.companyService.fetchCompany();
        return ResponseEntity.ok(allCompanyList);

    }

    @PutMapping("/company")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyRequest companyRequest) {
        Company savedCompany = this.companyService.updateCompany(companyRequest);
        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<?> fetchCompanyById(@PathVariable Integer id) throws Exception {
        Company companyById = this.companyService.fetchCompanyById(id);
        return ResponseEntity.ok(companyById);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) throws Exception {
        String message = this.companyService.deleteCompanyById(id);
        return ResponseEntity.ok(message);
    }



}


