package jp.personal.gi.pipe_main.domain.models.talkroom;

import jp.personal.gi.pipe_main.domain.support.entity.Entity;

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
