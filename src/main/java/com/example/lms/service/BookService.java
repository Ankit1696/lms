package com.example.lms.service;

import com.example.lms.exceptions.LibExceptions;
import com.example.lms.model.Book;
import com.example.lms.repository.BookRepository;
import com.example.lms.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void removeBook(int id){
         bookRepository.deleteById(id);
    }

    public Book getBook(int id) throws LibExceptions {
        return bookRepository.findById(id).orElseThrow(()-> new LibExceptions("book not found"));
    }

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
}
