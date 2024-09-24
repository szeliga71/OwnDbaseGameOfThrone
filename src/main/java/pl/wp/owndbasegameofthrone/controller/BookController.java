package pl.wp.owndbasegameofthrone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.service.BookService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String getAllBooks(Model model){
        List<Book> books=bookService.getAllBooks();
        model.addAttribute("bookList", books);
        return "books";
    }
}
