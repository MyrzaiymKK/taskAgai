package org.example.dao;

import org.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDao {
    String save (Address address);
   Optional<Address>  getAddressById(Long addressId);
   List<Address> getAllAddress();
    void updateAddress(Long addressId,Address newaddress);
   String deleteAddressById(Long addressId);


}
