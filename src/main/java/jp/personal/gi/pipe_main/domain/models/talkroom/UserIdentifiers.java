package jp.personal.gi.pipe_main.domain.models.talkroom;

import jp.personal.gi.pipe_main.domain.models.user.*;

import java.util.*;

public class UserIdentifiers {
    private final List<UserId> userIdentifiers;

    public UserIdentifiers(List<UserId> userIdentifiers) {
        this.userIdentifiers = userIdentifiers;
    }

    public List<UserId> getUserIdentifiers() {
        return userIdentifiers;
    }

    @Override
    public String toString() {
        return "UserIdentifiers{" +
                "userIdentifiers=" + userIdentifiers +
                '}';
    }
}
