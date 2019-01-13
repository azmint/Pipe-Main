package jp.personal.gi.pipe_main.core.services.user.search;

import jp.personal.gi.pipe_main.core.models.user.User;
import jp.personal.gi.pipe_main.core.models.user.UserRepository;
import jp.personal.gi.pipe_main.core.models.user.Users;

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
