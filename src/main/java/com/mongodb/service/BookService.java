package com.mongodb.service;

import com.mongodb.payload.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);
}
