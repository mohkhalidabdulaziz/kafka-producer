package com.khalid.book.publisher.services;

import com.khalid.book.publisher.domain.Book;

/**
 * Publishes books.
 */
public interface BookPublisherService {

    void publish(Book book);

}
