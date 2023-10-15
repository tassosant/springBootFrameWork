package tasos.springframework.simple_web_application.repositories;

import org.springframework.data.repository.CrudRepository;
import tasos.springframework.simple_web_application.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
