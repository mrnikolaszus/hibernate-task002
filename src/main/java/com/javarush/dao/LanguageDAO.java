package com.javarush.dao;

import com.javarush.domain.Address;
import com.javarush.domain.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends BaseDao<Language> {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
