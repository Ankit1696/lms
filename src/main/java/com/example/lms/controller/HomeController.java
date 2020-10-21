package com.example.lms.controller;

import com.example.lms.function.SubString;
import com.example.lms.model.Book;
import com.example.lms.model.IssuedBook;
import com.example.lms.repository.BookRepository;
import com.example.lms.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IssuedBookRepository issuedBookRepository;
    @Autowired
    BookRepository bookRepository;
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(path = "/addBook")
    public String addBook( ){
        return "addBook";
    }
    @RequestMapping("setBook")
    public String setBook(Book book){
        bookRepository.save(book);
        return "addBook";
    }


    @RequestMapping("issueBook")
    public String issueBook(@RequestParam int id, Model model){

        Book book = (Book) bookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("book not found"));

        IssuedBook issuedBook = new IssuedBook(book.getId(), book.getName(), book.getAuthor());
        issuedBookRepository.save(issuedBook);

        List<IssuedBook> list = new ArrayList<>();
        list.add(issuedBook);
        model.addAttribute("list", list);
        bookRepository.delete(book);
        return "viewIssuedBook";
    }


    @RequestMapping("returnBook")
    public String reuturnBook( int id){

        IssuedBook issuedBook = (IssuedBook) issuedBookRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("book not found"));
        Book book = new Book(issuedBook.getId(), issuedBook.getIbname(), issuedBook.getIbauthor());
        bookRepository.save(book);
        issuedBookRepository.delete(issuedBook);

        return "home";
    }



    @GetMapping("availableBookInLibrary")
    public String avlblBook(Book book, Model model){
        List<Book> list = bookRepository.findAll();
        model.addAttribute("list", list);
        return "availableBookInLibrary";
    }

    @GetMapping("viewIssuedBook")
    public String  geteEmps(IssuedBook issuedBook, Model model) {
        List<IssuedBook> list= issuedBookRepository.findAll();
        model.addAttribute("list", list);
        return "viewIssuedBook";


    }

    @RequestMapping("remove")
    public String remove(){
        return "remove";
    }



    @RequestMapping("deleteBook")
    public String delBook(@RequestParam int id){
        Book book = (Book) bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("not found"));
        bookRepository.deleteById(id);
        return "home";
    }
    @Autowired
    SubString subString;

    @RequestMapping("search")
    public String serch(String name,Book book, Model model){

        List<Book> bookList = bookRepository.findAll();
        List<Book> ans = new ArrayList<>();

        for(int i=0;i<bookList.size();i++){
            if(subString.isSubstring(name.toLowerCase(),bookList.get(i).getName().toLowerCase() )
                     || bookList.get(i).getAuthor().equalsIgnoreCase(name)){
                Book book1 = new Book(bookList.get(i).getId(), bookList.get(i).getName(), bookList.get(i).getAuthor());
                ans.add(book1);
            }
        }


        model.addAttribute("list", ans);
        return "search";
    }



}
