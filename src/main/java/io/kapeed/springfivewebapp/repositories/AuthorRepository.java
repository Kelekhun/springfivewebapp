package io.kapeed.springfivewebapp.repositories;

import io.kapeed.springfivewebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

