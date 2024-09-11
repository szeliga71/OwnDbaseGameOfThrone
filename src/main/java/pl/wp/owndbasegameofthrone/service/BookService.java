package pl.wp.owndbasegameofthrone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void saveBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }
    @Transactional
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }
}
