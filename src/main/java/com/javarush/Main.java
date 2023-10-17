package com.javarush;

import com.javarush.dao.*;
import com.javarush.domain.*;
import com.javarush.services.FilmService;
import com.javarush.util.EntityUtility;
import com.javarush.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        FilmService filmService = new FilmService(sessionFactory);

        Customer customer = filmService.createCustomer();
        filmService.rentFilm(customer);
        filmService.createNewFilm();
        filmService.returnFilm();
    }

}