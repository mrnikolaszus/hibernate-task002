package com.javarush.dao;

import com.javarush.dao.BaseDao;
import com.javarush.domain.Address;
import com.javarush.domain.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends BaseDao<FilmText> {
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
