package org.example.service;

import org.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    String save (Address address);
    Address getAddressById(Long addressId);
    List<Address> getAllAddress();
    void updateAddress(Long addressId,Address newaddress);
    String deleteAddressById(Long addressId);
}
