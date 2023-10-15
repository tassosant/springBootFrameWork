package tasos.springframework.simple_web_application.domain;

import java.util.Set;

public class Book {
        private String title;
        private String isbn;
        private Set<Author> authors;

        public Book(){

        }

        public Book(String title, String isbn, Set<Author> authors) {
            this.title = title;
            this.isbn = isbn;
            this.authors = authors;
        }
}
