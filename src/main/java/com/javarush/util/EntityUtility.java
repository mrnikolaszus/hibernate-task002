package com.javarush.util;

import com.javarush.dao.*;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;

@UtilityClass
public class EntityUtility {

    private static ActorDAO actorDAO;
    private static AddressDAO addressDAO;
    private static CategoryDAO categoryDAO;
    private static CityDAO cityDAO;
    private static CountryDAO countryDAO;
    private static CustomerDAO customerDAO;
    private static FilmDAO filmDAO;
    private static FilmTextDAO filmTextDAO;
    private static InventoryDAO inventoryDAO;
    private static LanguageDAO languageDAO;
    private static PaymentDAO paymentDAO;
    private static RentalDAO rentalDAO;
    private static StaffDAO staffDAO;
    private static StoreDAO storeDAO;

    public static void initialize(SessionFactory sessionFactory) {
        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static ActorDAO getActorDAO() {
        return actorDAO;
    }

    public static AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public static CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public static CityDAO getCityDAO() {
        return cityDAO;
    }

    public static CountryDAO getCountryDAO() {
        return countryDAO;
    }

    public static CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public static FilmDAO getFilmDAO() {
        return filmDAO;
    }

    public static FilmTextDAO getFilmTextDAO() {
        return filmTextDAO;
    }

    public static InventoryDAO getInventoryDAO() {
        return inventoryDAO;
    }

    public static LanguageDAO getLanguageDAO() {
        return languageDAO;
    }

    public static PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public static RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public static StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public static StoreDAO getStoreDAO() {
        return storeDAO;
    }
}