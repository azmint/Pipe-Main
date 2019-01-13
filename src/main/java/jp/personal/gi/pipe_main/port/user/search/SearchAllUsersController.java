package jp.personal.gi.pipe_main.port.user.search;

import jp.personal.gi.pipe_main.core.models.user.Users;
import jp.personal.gi.pipe_main.core.services.user.search.SearchAllUsersService;
import jp.personal.gi.pipe_main.port.user.UserPresenter;
import jp.personal.gi.pipe_main.port.user.UserRecord;

import java.util.function.Supplier;
import java.util.stream.Stream;

public abstract class SearchAllUsersController implements Supplier<Stream<UserRecord>> {
    private final SearchAllUsersService searchAllUsersService;

    public SearchAllUsersController(SearchAllUsersService searchAllUsersService) {
        this.searchAllUsersService = searchAllUsersService;
    }

    @Override
    public Stream<UserRecord> get() {
        Users allUsers = this.searchAllUsersService.get();
        return allUsers
                .toStream()
                .map(UserPresenter::new);
    }
}
