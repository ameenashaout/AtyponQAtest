package apiTest;

import com.learning.atypon.spring.mvc.repository.AuthorRepository;
import com.learning.atypon.spring.mvc.repository.BookRepository;
import com.learning.atypon.spring.mvc.service.AuthorServiceImpl;
import com.learning.atypon.spring.mvc.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class AuthorServiceTests {
    @Mock
    private AuthorRepository authorRepository;
    private AuthorServiceImpl authorUnderTest;


    @Test
    void canGetAuthorByFirstAndLastName(){
    authorUnderTest.findAuthorByFirstNameAndLastName("test","test");
    verify(authorRepository).findAuthorByFirstNameAndLastName("test","test");
      }



}
