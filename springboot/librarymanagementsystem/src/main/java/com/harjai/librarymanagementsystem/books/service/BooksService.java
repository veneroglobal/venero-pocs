package com.harjai.librarymanagementsystem.books.service;


import com.harjai.librarymanagementsystem.books.entity.Books;
import com.harjai.librarymanagementsystem.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookrepository;


    public Books save(Books books) {
        Books book = bookrepository.save(books);
        return book;
    }

    public List<Books> getbook() {
        List<Books> bookList = (List<Books>) bookrepository.findAll();
        return bookList;
    }


//    public List<Books> findAll() {
//        return ;
//
//    }
}

