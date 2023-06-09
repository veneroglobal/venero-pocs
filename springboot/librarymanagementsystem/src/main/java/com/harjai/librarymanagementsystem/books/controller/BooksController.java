package com.harjai.librarymanagementsystem.books.controller;

import com.harjai.librarymanagementsystem.books.service.BooksService;
import com.harjai.librarymanagementsystem.books.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/lib")
public class BooksController {



    @Autowired
    private BooksService bookservice;


//    @PostMapping()
//    public Books add(@RequestBody Books books) {
//       return this.bookservice.save(books);
//    }

    @GetMapping("/books")
    public List<Books> get() {
        return bookservice.getbook();
    }
}





