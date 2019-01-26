package jp.personal.gi.pipe_main.interfaces.user;

import jp.personal.gi.pipe_main.domain.models.user.User;

public class UserPresenter implements UserRecord {
    private final User user;

    public UserPresenter(User user) {
        this.user = user;
    }

    @Override
    public String getId() {
        return this.user.getId().getValue();
    }
}
