package io.kapeed.springfivewebapp.bootstrap;

import io.kapeed.springfivewebapp.model.Author;
import io.kapeed.springfivewebapp.model.Book;
import io.kapeed.springfivewebapp.model.Publisher;
import io.kapeed.springfivewebapp.repositories.AuthorRepository;
import io.kapeed.springfivewebapp.repositories.BookRepository;
import io.kapeed.springfivewebapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        // Publisher for Book ddd
        Publisher publisher = new Publisher();
        publisher.setName("McGraw Hill");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Publisher for Book noEJB
        Publisher nextPublisher = new Publisher();
        nextPublisher.setName("Ekta Publication");
        nextPublisher.setAddress("24th Street, Lalitpur");
        publisherRepository.save(nextPublisher);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", nextPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}