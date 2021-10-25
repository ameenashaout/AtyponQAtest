package apiTest;

import com.learning.atypon.spring.mvc.domain.entity.AuthorEntity;
import com.learning.atypon.spring.mvc.domain.entity.BookEntity;
import com.learning.atypon.spring.mvc.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@DataJpaTest
public class AuthorTests {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void findAuthorByFirstNameAndLastName(){

        AuthorEntity author=new AuthorEntity();
        author.setLastName("robert");
        author.setFirstName("joe");
        authorRepository.save(author);

        Optional<AuthorEntity> authors=authorRepository.findAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName());

        }
}
