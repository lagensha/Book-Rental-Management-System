package edu.icet.ecom.repository;

import edu.icet.ecom.repository.impl.BookRentRepositoryImpl;
import edu.icet.ecom.repository.impl.BookRepositoryImpl;
import edu.icet.ecom.repository.impl.CustomerRepositoryImpl;

public class RepositoryFactory {
    private static RepositoryFactory instance;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public enum RepositoryType {
        BOOK,
        CUSTOMER,
        BOOK_RENTAL
    }

    public <T> T getRepository(RepositoryType repositoryType) {
        switch (repositoryType) {
            case BOOK:
                return (T) new BookRepositoryImpl();
            case CUSTOMER:
                return (T) new CustomerRepositoryImpl();
            case BOOK_RENTAL:
                return (T) new BookRentRepositoryImpl();
            default:
                return null;
        }
    }

}
