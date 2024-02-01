package org.example.dao;

import org.example.entities.Company;

import java.util.List;
import java.util.Optional;

public interface ProgrammerDao {
    String save (Company company);
    Optional<Company> getAddressById(Long compamyId);
    List<Company> getAllAddress();
    void updateAddress(Long companyId,Company company);
    String deleteAddressById(Long companyId);
}
