package com.khalid.bookpublisher.services;


import com.khalid.bookpublisher.domain.Book;

/**
 * Publishes books.
 */
public interface BookPublisherService {

    void publish(Book book);

}
