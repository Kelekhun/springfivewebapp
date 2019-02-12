package io.kapeed.springfivewebapp.repositories;

import io.kapeed.springfivewebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}

