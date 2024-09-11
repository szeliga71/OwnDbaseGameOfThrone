package pl.wp.owndbasegameofthrone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wp.owndbasegameofthrone.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
