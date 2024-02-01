package org.example;

import org.example.config.HibernateConfig;
import org.example.entities.Address;
import org.example.entities.Company;
import org.example.service.CompanyService;
import org.example.service.impl.AddressServiceImpl;
import org.example.service.impl.CompanyServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println(HibernateConfig.getEntity());
        AddressServiceImpl addressService = new AddressServiceImpl();
        //addressService.save(new Address("KG"));
        //System.out.println(addressService.getAllAddress());
        // addressService.deleteAddressById(1L);

       // System.out.println(addressService.getAddressById(2L));


        CompanyServiceImpl companyService = new CompanyServiceImpl();
//        companyService.save(new Company("Google"));
//        companyService.assignCompanyToAddress(1L,1L);
        companyService.

    }
}
