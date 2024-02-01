package org.example.service;

import org.example.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    String save (Company company);
    Company getCompanyById(Long compamyId);
    List<Company> getAllCompany();
    void updateCompany(Long companyId,Company company);
    String deletecCompanyId(Long companyId);
    String assignCompanyToAddress(Long companyId,Long addressId);
}
