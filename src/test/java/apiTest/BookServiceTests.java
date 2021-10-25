package apiTest;

import com.learning.atypon.spring.mvc.repository.BookRepository;
import com.learning.atypon.spring.mvc.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {
    @Mock
    private BookRepository bookRepository;
    private BookServiceImpl bookUnderTest;

    @BeforeEach
    void setUp(){
        bookUnderTest=new BookServiceImpl();
    }

    @Test
    void canGetAllBook(){
        //when
        bookUnderTest.findAll();
        //then
        verify(bookRepository).findAll();
    }


}
