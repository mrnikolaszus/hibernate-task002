package com.javarush.dao;

import com.javarush.domain.Address;
import com.javarush.domain.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends BaseDao<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyCurrentRental() {
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}