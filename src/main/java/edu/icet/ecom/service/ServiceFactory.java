package edu.icet.ecom.service;

import edu.icet.ecom.service.impl.BookRentalServiceImpl;
import edu.icet.ecom.service.impl.BookServiceImpl;
import edu.icet.ecom.service.impl.CustomerServiceImpl;

public class ServiceFactory {

        private static ServiceFactory instance;


        private ServiceFactory() {}

        public static ServiceFactory getInstance() {
            if (instance == null) {
                instance = new ServiceFactory();
            }
            return instance;
        }


        public enum ServiceType {
            BOOK, CUSTOMER, BOOK_RENT
        }


        public <T> T getService(ServiceType serviceType) {
            switch (serviceType) {
                case BOOK:     return (T) new BookServiceImpl();
                case CUSTOMER: return (T) new CustomerServiceImpl();
                case BOOK_RENT: return (T) new BookRentalServiceImpl();
                default: return null;
            }
        }
    }

