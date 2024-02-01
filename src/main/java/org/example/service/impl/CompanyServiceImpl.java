package org.example.service.impl;

import org.example.dao.CompanyDao;
import org.example.dao.impl.CompanyDaoImpl;
import org.example.entities.Company;
import org.example.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    CompanyDao companyDao = new CompanyDaoImpl();

    @Override
    public String save(Company company) {
       return companyDao.save(company);
    }

    @Override
    public Company getCompanyById(Long compamyId) {
        companyDao.get
        return null;
    }

    @Override
    public List<Company> getAllCompany() {
        return null;
    }

    @Override
    public void updateCompany(Long companyId, Company company) {

    }

    @Override
    public String deletecCompanyId(Long companyId) {
        return null;
    }

    @Override
    public String assignCompanyToAddress(Long companyId, Long addressId) {
        return null;
    }
}
