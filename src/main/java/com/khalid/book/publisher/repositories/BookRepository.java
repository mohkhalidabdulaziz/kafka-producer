package com.khalid.book.publisher.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.khalid.book.publisher.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>,
        PagingAndSortingRepository<Book, Long> {
}
