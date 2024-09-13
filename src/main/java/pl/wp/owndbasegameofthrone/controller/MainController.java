package pl.wp.owndbasegameofthrone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.model.CharacterGoT;
import pl.wp.owndbasegameofthrone.service.BookService;
import pl.wp.owndbasegameofthrone.service.CharacterService;
import pl.wp.owndbasegameofthrone.sourceConnection.BookAPIHandler;
import pl.wp.owndbasegameofthrone.sourceConnection.CharacterAPIHandler;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BookAPIHandler bookAPIHandler;
    @Autowired
    BookService bookService;

    @Autowired
    CharacterAPIHandler characterAPIHandler;
    @Autowired
    CharacterService characterService;


    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
   /*@PostMapping("/")
    public String sendListOfBooks(Model model, @RequestParam("bookList")List<Book> bookList) {
       List<Book> bookList = bookAPIHandler.getAllBooks();
       bookService.saveBooks(bookList);
       model.addAttribute("bookList", bookList);
       return "books";
    }*/

    @GetMapping("/saveBook")
    public String saveBook(Model model) {
        List<Book> books = bookAPIHandler.getAllBooks();
        bookService.saveBooks(books);
        return "saveBook";
    }

    @GetMapping("/saveCharacters")
    public String saveCharacter(Model model) {
        List<CharacterGoT>characters = characterAPIHandler.getAllCharactersLoop();
        characterService.saveCharacters(characters);
        return "saveCharacters";
    }

  //  @PostMapping("/")
    //public String saveBooksToMyDB(@ModelAttribute("books") List<Book> books){
      //  bookService.saveBooks(books);
        //return "books";
    //}
}
