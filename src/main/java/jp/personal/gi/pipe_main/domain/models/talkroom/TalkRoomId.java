package jp.personal.gi.pipe_main.domain.models.talkroom;

import jp.personal.gi.pipe_main.domain.support.entity.EntityId;

import java.util.Objects;

public class TalkRoomId implements EntityId {
    private final String value;

    public TalkRoomId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TalkRoomId that = (TalkRoomId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TalkRoomId{" +
                "value='" + value + '\'' +
                '}';
    }
}
