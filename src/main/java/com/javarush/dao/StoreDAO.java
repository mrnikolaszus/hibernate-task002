package com.javarush.dao;

import com.javarush.domain.Address;
import com.javarush.domain.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends BaseDao<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
