package com.javarush.dao;

import com.javarush.domain.Address;
import com.javarush.domain.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends BaseDao<Customer> {
    public CustomerDAO( SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
