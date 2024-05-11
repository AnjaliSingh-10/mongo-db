package com.mongodb.controller;

import com.mongodb.payload.BookDto;
import com.mongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class Controller {

    @Autowired
    private BookService bookService;
   @PostMapping
    public ResponseEntity<BookDto>createBook(@RequestBody BookDto bookDto){
        BookDto dto = bookService.createBook(bookDto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED);
    }
}

