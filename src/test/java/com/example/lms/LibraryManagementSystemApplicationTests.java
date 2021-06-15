//package com.example.lms;
//
//import com.example.lms.controller.HomeController;
//import com.example.lms.exceptions.LibExceptions;
//import com.example.lms.model.Book;
//import com.example.lms.repository.BookRepository;
//import com.example.lms.service.BookService;
//import com.sun.source.tree.ModuleTree;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.util.AssertionErrors;
//import org.springframework.ui.Model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class LibraryManagementSystemApplicationTests {
//
//    @Autowired
//    private BookService bookService;
//
//    @MockBean
//    BookRepository bookRepository;
//
//
//    @Test
//    void testAdd() throws Exception {
//        Book book = new Book();
//        book.setAuthor("Ankit");
//        book.setName("TheArtOfJava");
//        book.setId(1);
//
//        Mockito.when(bookRepository.save(book)).thenReturn(book);
//        assertThat(bookService.addBook(book)).isEqualTo(book);
//    }
//
//    @Test
//    void testDel() throws Exception {
//        Book book = new Book();
//        book.setAuthor("Ankit");
//        book.setName("TheArtOfJava");
//        book.setId(1);
//
//        Mockito.when(bookRepository.findById(1)).thenReturn(java.util.Optional.of(book));
//        Mockito.when(bookRepository.existsById(book.getId())).thenReturn(false);
//        AssertionErrors.assertFalse("workded", bookRepository.existsById(book.getId()));
//    }
//
//    @Test
//    void findById() throws Exception{
//        Book book = new Book();
//        book.setAuthor("Ankit");
//        book.setName("TheArtOfJava");
//        book.setId(1);
//        Mockito.when(bookRepository.findById(1)).thenReturn(java.util.Optional.of(book));
//        assertThat(bookService.getBook(1)).isEqualTo(book);
//    }
//    @Test
//    void findAll() throws Exception{
//        Book book = new Book();
//        book.setAuthor("Ankit");
//        book.setName("TheArtOfJava");
//        book.setId(1);
//        List<Book> list = new ArrayList<>();
//        list.add(book);
//        Mockito.when(bookRepository.findAll()).thenReturn(list);
//        assertThat(bookService.allBooks()).isEqualTo(list);
//    }
//
//}