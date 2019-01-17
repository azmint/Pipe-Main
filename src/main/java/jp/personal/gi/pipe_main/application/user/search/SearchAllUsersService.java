package jp.personal.gi.pipe_main.application.user.search;

import jp.personal.gi.pipe_main.domain.models.user.User;
import jp.personal.gi.pipe_main.domain.models.user.UserRepository;
import jp.personal.gi.pipe_main.domain.models.user.Users;

import java.util.function.Supplier;
import java.util.stream.Stream;

public abstract class SearchAllUsersService implements Supplier<Users> {
    private final UserRepository repository;

    public SearchAllUsersService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users get() {
        Stream<User> allUsers = this.repository.findAll();
        return Users.of(allUsers);
    }
}
