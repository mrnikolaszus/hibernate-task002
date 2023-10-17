package com.javarush.services;

import com.javarush.domain.*;
import com.javarush.util.EntityUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmService {
    private final SessionFactory sessionFactory;

    public FilmService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        EntityUtility.initialize(sessionFactory);
    }

    public void createNewFilm() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
              Language language = EntityUtility.getLanguageDAO().findAll()
                            .stream().unordered().findAny().get();

            List<Category> categories = EntityUtility.getCategoryDAO().getItems(0,5);
            List<Actor> actors = EntityUtility.getActorDAO().getItems(0, 5);

            Film film = new Film();
            film.setActors(new HashSet<>(actors));
            film.setRating(Rating.PG);
            film.setSpecialFeatures(Set.of(Feature.BEHIND_THE_SCENES, Feature.DELETED_SCENES));
            film.setLength((short)90);
            film.setReplacementCost(BigDecimal.valueOf(66.66));
            film.setReplacementCost(BigDecimal.valueOf(666.66));
            film.setLanguage(language);
            film.setDescription("TestFilm9");
            film.setTitle("TestTitle9");
            film.setRentalDuration((byte) 10);
            film.setOriginalLanguage(language);
            film.setCategories(new HashSet<>(categories));
            film.setRentalRate(BigDecimal.ZERO);
            film.setYear(Year.now());
            EntityUtility.getFilmDAO().save(film);

            FilmText filmText = new FilmText();
            filmText.setId(film.getId());
            filmText.setFilm(film);
            filmText.setDescription("TestFilm9");
            filmText.setTitle("TestTitle9");
            EntityUtility.getFilmTextDAO().save(filmText);
            session.getTransaction().commit();
        }
    }

    public void rentFilm(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var film = EntityUtility.getFilmDAO().getFirstFilm();

            Store store = EntityUtility.getStoreDAO().getItems(0, 1).get(0);
            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);

            EntityUtility.getInventoryDAO().save(inventory);

            Staff staff = store.getStaff();
            System.err.println(staff);
            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);

            EntityUtility.getRentalDAO().save(rental);

            Payment payment = new Payment();
            payment.setAmount(BigDecimal.valueOf(99.99));
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRental(rental);
            payment.setStaff(staff);

            EntityUtility.getPaymentDAO().save(payment);
            session.getTransaction().commit();
        }
    }

    public void returnFilm() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Rental rental = EntityUtility.getRentalDAO().getAnyCurrentRental();
            rental.setReturnDate(LocalDateTime.now());

            EntityUtility.getRentalDAO().save(rental);
            session.getTransaction().commit();
        }
    }

    public Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Store store = EntityUtility.getStoreDAO().getItems(0, 1).get(0);

            var city = EntityUtility.getCityDAO().getByName("Kragujevac");


            Address address = new Address();
            address.setAddress("TestAddress2");
            address.setPhone("12312312");
            address.setCity(city);
            address.setDistrict("TestDistrict2");
            EntityUtility.getAddressDAO().save(address);

            Customer customer = new Customer();
            customer.setActive(true);
            customer.setEmail("test@gmail.com");
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName("TestName");
            customer.setLastName("TestLastName");
            EntityUtility.getCustomerDAO().save(customer);
            session.getTransaction().commit();
            return customer;
        }
    }
}