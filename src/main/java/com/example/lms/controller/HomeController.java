package com.example.lms.controller;

import com.example.lms.exceptions.LibExceptions;
import com.example.lms.function.SubString;
import com.example.lms.model.Book;
import com.example.lms.model.IssuedBook;
import com.example.lms.repository.BookRepository;
import com.example.lms.repository.IssuedBookRepository;
import com.example.lms.service.BookService;
import com.example.lms.service.IsdBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    IsdBookService isdBookService;
   @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(path = "/addBook")
    public String addBook( ){
        return "addBook";
    }
    @PostMapping("setBook")
    public String setBook(Book book){
        bookService.addBook(book);
        return "addBook";
    }


    @RequestMapping("issueBook")
    public String issueBook(@RequestParam int id, Model model) throws LibExceptions {

        Book book =  bookService.getBook(id);

        IssuedBook issuedBook = new IssuedBook(book.getId(), book.getName(), book.getAuthor());
        isdBookService.addIsdBook(issuedBook);

        List<IssuedBook> list = new ArrayList<>();
        list.add(issuedBook);
        model.addAttribute("list", list);
        bookService.removeBook(id);
        return "viewIssuedBook";
    }


    @RequestMapping("returnBook")
    public String reuturnBook( int id) throws LibExceptions {

        IssuedBook issuedBook = isdBookService.getIsdBook(id);
        Book book = new Book(issuedBook.getId(), issuedBook.getIbname(), issuedBook.getIbauthor());
        bookService.addBook(book);
       isdBookService.removeIsdBook(id);

        return "home";
    }



    @GetMapping("availableBookInLibrary")
    public String avlblBook( Model model){
        List<Book> list = bookService.allBooks();
        model.addAttribute("list", list);
        return "availableBookInLibrary";
    }

    @GetMapping("viewIssuedBook")
    public String  getBooks( Model model) {
        List<IssuedBook> list= isdBookService.allIsdBooks();
        model.addAttribute("list", list);
        return "viewIssuedBook";


    }

    @RequestMapping("remove")
    public String remove(){
        return "remove";
    }



    @RequestMapping("deleteBook")
    public String delBook(@RequestParam int id) throws LibExceptions {
        bookService.getBook(id);
        bookService.removeBook(id);
        return "home";
    }
    @Autowired
    SubString subString;

    @RequestMapping("search")
    public String search(String name, Model model){

        List<Book> bookList = bookService.allBooks();
        List<Book> ans = new ArrayList<>();

        for(int i=0;i<bookList.size();i++){
            if(subString.isSubstring(name.toLowerCase(),bookList.get(i).getName().toLowerCase() )
                     || bookList.get(i).getAuthor().equalsIgnoreCase(name)||(bookList.get(i).getId()+"").equalsIgnoreCase(name)){
                Book book1 = new Book(bookList.get(i).getId(), bookList.get(i).getName(), bookList.get(i).getAuthor());
                ans.add(book1);
            }
        }


        model.addAttribute("list", ans);
        return "search";
    }



}
