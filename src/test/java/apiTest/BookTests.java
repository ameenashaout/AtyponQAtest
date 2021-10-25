package apiTest;

import com.learning.atypon.spring.mvc.domain.entity.AuthorEntity;
import com.learning.atypon.spring.mvc.domain.entity.BookEntity;
import com.learning.atypon.spring.mvc.repository.AuthorRepository;
import com.learning.atypon.spring.mvc.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookTests {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void findAllBook(){
        AuthorEntity author=new AuthorEntity();
        author.setFirstName("ame");
        author.setLastName("joe");
        authorRepository.save(author);

        BookEntity bookOne = new BookEntity();
        bookOne.setAuthor(author);
        bookOne.setTitle("java");
        bookOne.setYear("2021");

        BookEntity  bookTwo = new BookEntity();
        bookTwo.setAuthor(author);
        bookTwo.setTitle("java");
        bookTwo.setYear("2021");


        BookEntity  bookThree = new BookEntity();
        bookThree.setAuthor(author);
        bookThree.setTitle("java");
        bookThree.setYear("2021");

        bookRepository.save(bookOne);
        bookRepository.save(bookTwo);
        bookRepository.save(bookThree);

        Iterable<BookEntity> books = bookRepository.findAll();

        assertThat(books).contains(bookOne, bookTwo, bookThree);

    }

    @Test
    public void findBookById(){
        AuthorEntity author=new AuthorEntity();
        author.setFirstName("Amal");
        author.setLastName("joe");
        authorRepository.save(author);

        BookEntity bookOne = new BookEntity();
        bookOne.setAuthor(author);
        bookOne.setTitle("java");
        bookOne.setYear("2021");
        bookRepository.save(bookOne);

        BookEntity bookTwo = new BookEntity();
        bookTwo.setAuthor(author);
        bookTwo.setTitle("design pattern");
        bookTwo.setYear("2020");
        bookRepository.save(bookTwo);
        BookEntity foundBook = bookRepository.findById(bookTwo.getId()).get();

        assertThat(foundBook).isEqualTo(bookTwo);
    }

    @Test
    public void findByTitleContaining(){
        AuthorEntity author=new AuthorEntity();
        author.setFirstName("Amal");
        author.setLastName("joe");

        BookEntity bookOne = new BookEntity();
        bookOne.setAuthor(author);
        bookOne.setTitle("java");
        bookOne.setYear("2021");

        BookEntity bookTwo = new BookEntity();
        bookTwo.setAuthor(author);
        bookTwo.setTitle("design pattern");
        bookTwo.setYear("2020");

        authorRepository.save(author);
        bookRepository.save(bookOne);
        bookRepository.save(bookTwo);

        Iterable<BookEntity> books=bookRepository.findByTitleContaining(bookTwo.getTitle());
        assertThat(books).contains(bookTwo);

    }
    @Test
    public void findByAuthor(){
        AuthorEntity author=new AuthorEntity();
        author.setFirstName("Amal");
        author.setLastName("joe");

        BookEntity bookOne = new BookEntity();
        bookOne.setAuthor(author);
        bookOne.setTitle("java");
        bookOne.setYear("2021");
        authorRepository.save(author);
        bookRepository.save(bookOne);

        Iterable<BookEntity> books=bookRepository.findByAuthor(author);
        assertThat(books).contains(bookOne);
    }
    @Test
    public void findByAuthorAndYear(){
        AuthorEntity author=new AuthorEntity();
        author.setFirstName("Amal");
        author.setLastName("joe");

        BookEntity bookOne = new BookEntity();
        bookOne.setAuthor(author);
        bookOne.setTitle("java");
        bookOne.setYear("2021");

        authorRepository.save(author);
        bookRepository.save(bookOne);

        Iterable<BookEntity> books=bookRepository.findByAuthorAndYear(author,bookOne.getYear());
        assertThat(books).contains(bookOne);
    }

}
