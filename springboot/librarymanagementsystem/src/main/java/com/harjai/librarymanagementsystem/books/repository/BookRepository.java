package com.harjai.librarymanagementsystem.books.repository;

import com.harjai.librarymanagementsystem.books.entity.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
}
