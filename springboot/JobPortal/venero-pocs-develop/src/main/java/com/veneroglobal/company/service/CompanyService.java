package com.veneroglobal.company.service;

import com.veneroglobal.common.dto.CompanyRequest;
import com.veneroglobal.common.entity.Address;
import com.veneroglobal.common.entity.Company;
import com.veneroglobal.common.entity.Region;
import com.veneroglobal.common.entity.User;
import com.veneroglobal.common.exception.custom.DuplicateEmailException;
import com.veneroglobal.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company savedCompany(CompanyRequest companyRequest) {

        Company company = new Company();

        company.setCompanyName(companyRequest.getCompanyName());
        company.setEmail(companyRequest.getEmail());
        company.setFoundedIn(companyRequest.getFoundedIn());
        company.setAreaOfOperation(companyRequest.getAreaOfOperation());
        company.setTypeOfMembership(companyRequest.getTypeOfMembership());
        company.setStatus(companyRequest.getStatus());

        Address address = new Address();
        address.setCity(companyRequest.getAddress().getState());
        address.setPinCode(companyRequest.getAddress().getPinCode());
        company.setAddress(companyRequest.getAddress());

        Region region = new Region();
        region.setShortCode(companyRequest.getRegion().getShortCode());
        region.setLongCode(companyRequest.getRegion().getLongCode());
        company.setRegion(companyRequest.getRegion());

        User user = new User();
        user.setId(companyRequest.);


        Company savecompany = new Company();


        try{
            savecompany = this.companyRepository.save(company);
        }catch (Exception e){
            throw new DuplicateEmailException("Duplicate Email Found");
        }
        return savecompany;
    }

    public List<Company> fetchCompany() {
        return (List<Company>) this.companyRepository.findAll();
    }

    public Company updateCompany(CompanyRequest companyRequest) {
       Optional<Company> existingCompany = this.companyRepository.findById(companyRequest.getId());
        Company company = null;
        if (existingCompany.isPresent()){
            company = existingCompany.get();
            company.setCompanyName(companyRequest.getCompanyName());
            company.setStatus(companyRequest.getStatus());
            company.setFoundedIn(companyRequest.getFoundedIn());
            company.setEmail(companyRequest.getEmail());
            company.setTypeOfMembership(companyRequest.getTypeOfMembership());
            company.setAreaOfOperation(companyRequest.getAreaOfOperation());

            this.companyRepository.save(company);

        }
        return company;

    }


    public Company fetchCompanyById(Integer id)throws Exception {
    Optional<Company> company = this.companyRepository.findById(id);
    if (company.isPresent()){
        return  company.get();
    }
    throw new Exception("company not found");
    }


    public String deleteCompanyById(Integer id)throws Exception {
        try{
            this.companyRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Company not found in the system......");
        }
        return "Company successfully Removed..";
    }

}






