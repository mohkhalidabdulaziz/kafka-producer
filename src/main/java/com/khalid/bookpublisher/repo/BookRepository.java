package com.khalid.bookpublisher.repo;

import com.khalid.bookpublisher.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book, Long>,
        PagingAndSortingRepository<Book, Long> {
}
