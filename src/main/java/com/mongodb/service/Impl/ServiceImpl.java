package com.mongodb.service.Impl;

import com.mongodb.Entity.Book;
import com.mongodb.payload.BookDto;
import com.mongodb.repository.BookRepository;
import com.mongodb.service.BookService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ServiceImpl implements BookService {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    public ServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public ServiceImpl() {
    }

    @Override
    public BookDto createBook (BookDto bookDto) {
        Book book = mapToEntity(bookDto);
        Book savebook = bookRepository.save(book);
       BookDto bookdto = mapToDto(savebook);
       return bookdto;
    }

    BookDto mapToDto(Book savedBook) {
        BookDto bookDto = modelMapper.map(savedBook, BookDto.class);
        return bookDto;
    }

    Book mapToEntity(BookDto savedBook) {
        Book book = modelMapper.map(savedBook, Book.class);
        return book;
    }
}