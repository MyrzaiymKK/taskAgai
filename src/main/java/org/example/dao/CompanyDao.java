package org.example.dao;

import org.example.entities.Address;
import org.example.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {
    String save (Company company);
    Optional<Company> getCompanyById(Long companyId);
    List<Company> getAllCompany();
    void updateCompany(Long companyId,Company company);
    String deleteCompanyById(Long companyId);
    String assignCompanyToAddress(Long companyId,Long addressId);

}
