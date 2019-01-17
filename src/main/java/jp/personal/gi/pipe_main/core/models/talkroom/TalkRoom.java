package jp.personal.gi.pipe_main.core.models.talkroom;

import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class TalkRoom extends Entity<TalkRoomId> {
    private final UserIdentifiers userIdentifiers;

    public TalkRoom(TalkRoomId id, UserIdentifiers userIdentifiers) {
        super(id);
        this.userIdentifiers = userIdentifiers;
    }

    public UserIdentifiers getUserIdentifiers() {
        return userIdentifiers;
    }

    @Override
    public String toString() {
        return "TalkRoom{" +
                "id=" + id +
                ", userIdentifiers=" + userIdentifiers +
                '}';
    }
}
