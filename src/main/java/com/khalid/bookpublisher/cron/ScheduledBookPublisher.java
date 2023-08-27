package com.khalid.bookpublisher.cron;

import com.khalid.bookpublisher.repo.BookRepository;
import com.khalid.bookpublisher.services.BookPublisherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Publishes books at a fixed interval.
 */
@Component
@Slf4j
public class ScheduledBookPublisher {

    private long counter;

    private final BookRepository bookRepository;

    private final BookPublisherService bookPublisherService;

    public ScheduledBookPublisher(final BookPublisherService bookPublisherService, final BookRepository bookRepository) {
        resetCounter();
        this.bookPublisherService = bookPublisherService;
        this.bookRepository = bookRepository;
    }

    /**
     * Task will be executed every 20 seconds.
     */
    @Scheduled(cron = "0/30 * * * * *")
    public void publishBook() {
        bookRepository.findById(counter).ifPresentOrElse(book -> {
            counter += 1;
            bookPublisherService.publish(book);
            log.info("Book '{}' [{}] published.", book.getTitle(), book.getIsbn());
        }, () -> resetCounter());
    }

    private void resetCounter() {
        this.counter = 1;
    }

}
