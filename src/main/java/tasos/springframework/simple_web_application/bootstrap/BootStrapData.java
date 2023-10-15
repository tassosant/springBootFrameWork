package tasos.springframework.simple_web_application.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tasos.springframework.simple_web_application.domain.Author;
import tasos.springframework.simple_web_application.domain.Book;
import tasos.springframework.simple_web_application.repositories.AuthorRepository;
import tasos.springframework.simple_web_application.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2ee Development without EJB", "908321547803");
        rod.getBooks().add(noEJB);
        ddd.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(ddd);
    }
}
