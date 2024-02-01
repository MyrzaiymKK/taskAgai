package org.example.service.impl;

import org.example.dao.AddressDao;
import org.example.dao.impl.AddressDaoImpl;
import org.example.entities.Address;
import org.example.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao = new AddressDaoImpl();
    @Override
    public String save(Address address) {
      return addressDao.save(address);
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressDao.getAddressById(addressId).get();
    }

    @Override
    public List<Address> getAllAddress() {

        return addressDao.getAllAddress();
    }

    @Override
    public void updateAddress(Long addressId, Address newaddress) {

    }

    @Override
    public String deleteAddressById(Long addressId) {
         return addressDao.deleteAddressById(addressId);
    }
}
