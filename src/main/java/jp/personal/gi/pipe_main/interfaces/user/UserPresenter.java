package jp.personal.gi.pipe_main.interfaces.user;

import jp.personal.gi.pipe_main.domain.models.user.*;

public class UserPresenter implements UserRecord {
    private final User user;

    public UserPresenter(User user) {
        this.user = user;
    }

    @Override
    public String getId() {
        return this.user.getId().getValue();
    }

    @Override
    public String getAccountId() {
        return this.user.getAccountId().getValue();
    }

    @Override
    public String getUserName() {
        return this.user.getUserName().getValue();
    }

    @Override
    public String getFriend_1() {
        return this.user.getFriends().getValues().stream().map(UserId::getValue).findFirst().orElse("");
    }

    @Override
    public String getFriend_2() {
        return this.user.getFriends().getValues().stream().skip(1L).map(UserId::getValue).findFirst().orElse("");
    }

    @Override
    public String getFriend_3() {
        return this.user.getFriends().getValues().stream().skip(2L).map(UserId::getValue).findFirst().orElse("");
    }

    @Override
    public String getFriend_4() {
        return this.user.getFriends().getValues().stream().skip(3L).map(UserId::getValue).findFirst().orElse("");
    }

    @Override
    public String getFriend_5() {
        return this.user.getFriends().getValues().stream().skip(4L).map(UserId::getValue).findFirst().orElse("");
    }
}
