package jp.personal.gi.pipe_main.interfaces.user.search;

import jp.personal.gi.pipe_main.application.user.search.*;
import jp.personal.gi.pipe_main.domain.models.user.*;
import jp.personal.gi.pipe_main.interfaces.user.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public abstract class SearchAllUsersController implements Supplier<List<UserRecord>> {
    private final SearchAllUsersService searchAllUsersService;

    public SearchAllUsersController(SearchAllUsersService searchAllUsersService) {
        this.searchAllUsersService = searchAllUsersService;
    }

    @Override
    public List<UserRecord> get() {
        Users allUsers = this.searchAllUsersService.get();
        return allUsers
                .toList()
                .stream()
                .map(UserPresenter::new)
                .collect(Collectors.toList());
    }
}
