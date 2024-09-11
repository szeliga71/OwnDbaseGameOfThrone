package pl.wp.owndbasegameofthrone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.service.BookService;
import pl.wp.owndbasegameofthrone.sourceConnection.BookAPIHandler;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BookAPIHandler bookAPIHandler;
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String getMainPage() {
        List<Book> bookList = bookAPIHandler.getAllBooks();
        return "index";
    }
   @PostMapping("/")
    public String sendListOfBooks(Model model, @RequestParam("bookList")List<Book> bookList) {

       bookService.saveBooks(bookList);
       model.addAttribute("bookList", bookList);
       return "books";
    }

 /*   @GetMapping("/saveBook")
    public String saveBook(Model model) {
        List<Book> books = bookAPIHandler.getAllBooks();
        bookService.saveBooks(books);
        return "saveBook";
    }*/

  //  @PostMapping("/")
    //public String saveBooksToMyDB(@ModelAttribute("books") List<Book> books){
      //  bookService.saveBooks(books);
        //return "books";
    //}
}
