package felipe.springframework.spring6webapp.bootstrap;

import felipe.springframework.spring6webapp.domain.Author;
import felipe.springframework.spring6webapp.domain.Book;
import felipe.springframework.spring6webapp.repositories.AuthorRepository;
import felipe.springframework.spring6webapp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("eric");
        eric.setLastName("evans");

        Book ddd = new Book();
        ddd.setTitle("Domain driven design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noejb = new Book();
        ddd.setTitle("J2EE development without EJB");
        ddd.setIsbn("5447575");

        Author rodSaved = authorRepository.save(rod);
        Book noejbSaved = bookRepository.save(noejb);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noejbSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());


    }
}
