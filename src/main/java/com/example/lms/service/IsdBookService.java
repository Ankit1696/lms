package com.example.lms.service;

import com.example.lms.exceptions.LibExceptions;
import com.example.lms.model.IssuedBook;
import com.example.lms.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsdBookService {
    @Autowired
    IssuedBookRepository issuedBookRepository;


    public IssuedBook addIsdBook(IssuedBook issuedBook){
        return issuedBookRepository.save(issuedBook);
    }

    public void removeIsdBook(int id){
        issuedBookRepository.deleteById(id);
    }

    public IssuedBook getIsdBook(int id) throws LibExceptions {
        return issuedBookRepository.findById(id).orElseThrow(()-> new LibExceptions("book not found"));
    }

    public List<IssuedBook> allIsdBooks(){
        return issuedBookRepository.findAll();
    }
}

