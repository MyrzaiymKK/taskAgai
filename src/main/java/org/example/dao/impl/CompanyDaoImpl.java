package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.CompanyDao;
import org.example.entities.Address;
import org.example.entities.Company;

import java.util.List;
import java.util.Optional;

public class CompanyDaoImpl implements CompanyDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntity();
    @Override
    public String save(Company company) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
            return company.getName() + "saved";
        }catch (Exception e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            return  e.getMessage();
        }
    }

    @Override
    public Optional<Company> getCompanyById(Long companyId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Company company = null;
        try {
            entityManager.getTransaction().begin();

            company = entityManager
                    .createQuery("select c from Company  c where c.id = :compId",Company.class)
                    .setParameter("compId",companyId)
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

        return Optional.ofNullable(company);
    }


    @Override
    public List<Company> getAllCompany() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Company> companies = entityManager.createQuery("select c from Company c",Company.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return companies;
    }

    @Override
    public void updateCompany(Long companyId, Company company) {

    }

    @Override
    public String deleteCompanyById(Long companyId) {
        return null;
    }

    @Override
    public String assignCompanyToAddress(Long companyId, Long addressId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Company company = entityManager.find(Company.class, companyId);
       Address address = entityManager.find(Address.class, addressId);
       company.setAddress(address);


        entityManager.merge(company);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "success";

    }
}
