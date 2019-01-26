package jp.personal.gi.pipe_main.domain.models.talkroom;

import jp.personal.gi.pipe_main.domain.models.user.UserId;

import java.util.stream.Stream;

public class UserIdentifiers {
    private final Stream<UserId> userIdentifiers;

    public UserIdentifiers(Stream<UserId> userIdentifiers) {
        this.userIdentifiers = userIdentifiers;
    }

    public Stream<UserId> getUserIdentifiers() {
        return userIdentifiers;
    }

    @Override
    public String toString() {
        return "UserIdentifiers{" +
                "userIdentifiers=" + userIdentifiers +
                '}';
    }
}
