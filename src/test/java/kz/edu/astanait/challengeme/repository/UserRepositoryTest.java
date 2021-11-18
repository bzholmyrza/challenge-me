
package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


    @DataJpaTest
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    class UserRepositoryTest {

        @Autowired
        private UserRepository userRepository;

        @Test
        @Order(1)
        @Rollback(value = false)
        public void testCreateUser() {
            User user = new User("John","Smith","johnsmith@gmail.com","UK","abc123456");

            userRepository.save(user);

            Assertions.assertThat(user.getId()).isGreaterThan(0);
        }

        @Test
        @Order(2)
        public void getUserTest(){
            User user = userRepository.findById(1L).get();

            Assertions.assertThat(user.getId()).isEqualTo(1L);
        }

        @Test
        @Order(3)
        public void getListOfUsersTest(){
            List<User> users = userRepository.findAll();

            Assertions.assertThat(users.size()).isGreaterThan(0);
        }

        @Test
        @Order(4)
        @Rollback(value = false)
        public void updateUserTest(){
            User user = userRepository.findById(1L).get();

            user.setFirstname("Aru");

            User userUpdated = userRepository.save(user);

            Assertions.assertThat(userUpdated.getFirstname()).isEqualTo("Aru");
        }

        @Test
        @Order(5)
        @Rollback(value = false)
        public void deleteUserTest(){
            User user = userRepository.findById(16L).get();

            userRepository.delete(user);

            User user1 = null;

            Optional<User> userDeleted = userRepository.findByIdAndEmail(16L,"johnsmith@gmail.com");

            if(userDeleted.isPresent()){
                user1 = userDeleted.get();
            }

            Assertions.assertThat(user1).isNull();
        }

        @BeforeAll
        public static void setupAll() {
            System.out.println("Hello! Testing is started");
        }


        @AfterAll
        public static void tearDownAll() {
            System.out.println("Good Bye! Testing is all done");
        }
    }

