package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Address;
import org.example.entities.Company;
import org.example.entities.Programmers;
import org.example.entities.Projects;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Collection;
import java.util.Properties;

public class HibernateConfig {
//    public static SessionFactory getSession() {
//
//        Properties properties = new Properties();
//        properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
//        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/java12");
//        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
//        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "postgres");
//        properties.put(Environment.HBM2DDL_AUTO, "create");
//        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put(Environment.SHOW_SQL, "true");
//
//        Configuration configuration = new Configuration();
//        configuration.addProperties(properties);
//        configuration.addAnnotatedClass(Student.class);
//        return configuration.buildSessionFactory();
//
//
//    }
    public static SessionFactory getSession(){
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_DRIVER,"org.postgresql.Driver");
        properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/jdbc");
        properties.put(Environment.JAKARTA_JDBC_USER,"postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD,"2020");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Programmers.class);
        configuration.addAnnotatedClass(Projects.class);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory getEntity(){
        return getSession().unwrap(EntityManagerFactory.class);
    }

}
