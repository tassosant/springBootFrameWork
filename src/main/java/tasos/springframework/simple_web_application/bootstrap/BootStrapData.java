package tasos.springframework.simple_web_application.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tasos.springframework.simple_web_application.domain.Author;
import tasos.springframework.simple_web_application.domain.Book;
import tasos.springframework.simple_web_application.domain.Publisher;
import tasos.springframework.simple_web_application.repositories.AuthorRepository;
import tasos.springframework.simple_web_application.repositories.BookRepository;
import tasos.springframework.simple_web_application.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Tasos");
        publisher.setCity("Athens");
        publisher.setState("FL");


        publisherRepository.save(publisher);


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2ee Development without EJB", "908321547803");
        rod.getBooks().add(noEJB);
        ddd.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        publisherRepository.save(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
