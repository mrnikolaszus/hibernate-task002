package com.javarush.dao;

import com.javarush.domain.Address;
import com.javarush.domain.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends BaseDao<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getFirstFilm() {
        Query<Film> query = getCurrentSession().createQuery("select f from Film f " +
                " where f.id not in (select distinct film.id from Inventory )", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
