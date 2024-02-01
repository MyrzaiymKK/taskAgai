package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.AddressDao;
import org.example.entities.Address;

import java.util.List;
import java.util.Optional;

public class AddressDaoImpl implements AddressDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntity();
    @Override
    public String save(Address address) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            return address.getCountry() + "saved";
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            return  e.getMessage();
        }


    }

    @Override
    public Optional<Address> getAddressById(Long addressId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Address address = null;
        try {
            entityManager.getTransaction().begin();

            address = entityManager
                    .createQuery("select a from Address  a where a.id = :addId",Address.class)
                    .setParameter("addId",addressId)
                    .getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception e){

            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }

        return Optional.ofNullable(address);

    }


    @Override
    public List<Address> getAllAddress() {
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     List<Address> addresses = entityManager.createQuery("select a from Address a", Address.class).getResultList();
     entityManager.getTransaction().commit();
     entityManager.close();
        return addresses;
    }

    @Override
    public void updateAddress(Long addressId, Address newaddress) {

    }

    @Override
    public String deleteAddressById(Long addressId) {
     return null;
    }
}
