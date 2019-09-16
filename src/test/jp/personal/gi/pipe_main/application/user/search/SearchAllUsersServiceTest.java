package jp.personal.gi.pipe_main.application.user.search;

import jp.personal.gi.pipe_main.domain.models.account.*;
import jp.personal.gi.pipe_main.domain.models.user.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class SearchAllUsersServiceTest {
    class MockUserRepository implements UserRepository {
        @Override
        public Optional<User> findBy(UserId id) {
            return Optional.empty();
        }

        @Override
        public List<User> findAll() {
            return Arrays.asList(
                    new User(new UserId("1"), new AccountId("1"), new UserName("Taro"), new Friends(new ArrayList<>())),
                    new User(new UserId("2"), new AccountId("2"), new UserName("Jiro"), new Friends(new ArrayList<>())));
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    class MockSearchAllUsersService extends SearchAllUsersService {
        MockSearchAllUsersService(UserRepository repository) {
            super(repository);
        }
    }

    @Test
    public void getTest() {
        final MockUserRepository mockUserRepository = new MockUserRepository();
        final MockSearchAllUsersService mockSearchAllUsersService = new MockSearchAllUsersService(mockUserRepository);
        final Users users = mockSearchAllUsersService.get();
        final List<User> userList = mockUserRepository.findAll();
        assertEquals(users.toList(), userList);
    }
}