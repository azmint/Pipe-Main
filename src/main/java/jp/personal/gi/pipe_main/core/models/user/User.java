package jp.personal.gi.pipe_main.core.models.user;

import jp.personal.gi.pipe_main.core.models.account.AccountId;
import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class User extends Entity<UserId> {
    private final AccountId accountId;
    private final UserName userName;
    private final Friends friends;

    public User(UserId id, AccountId accountId, UserName userName, Friends friends) {
        super(id);
        this.accountId = accountId;
        this.userName = userName;
        this.friends = friends;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public UserName getUserName() {
        return userName;
    }

    public Friends getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", userName=" + userName +
                ", friends=" + friends +
                '}';
    }
}
