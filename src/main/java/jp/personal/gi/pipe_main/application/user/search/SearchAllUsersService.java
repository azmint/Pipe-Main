package jp.personal.gi.pipe_main.application.user.search;

import jp.personal.gi.pipe_main.domain.models.user.*;

import java.util.*;
import java.util.function.*;

public abstract class SearchAllUsersService implements Supplier<Users> {
    private final UserRepository repository;

    public SearchAllUsersService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Users get() {
        List<User> allUsers = this.repository.findAll();
        return Users.of(allUsers);
    }
}
