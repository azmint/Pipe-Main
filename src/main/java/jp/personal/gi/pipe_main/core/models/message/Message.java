package jp.personal.gi.pipe_main.core.models.message;

import jp.personal.gi.pipe_main.core.models.talkroom.TalkRoomId;
import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class Message extends Entity<MessageId> {
    private final TalkRoomId talkRoomId;
    private final Text text;

    public Message(MessageId id, TalkRoomId talkRoomId, Text text) {
        super(id);
        this.talkRoomId = talkRoomId;
        this.text = text;
    }

    public TalkRoomId getTalkRoomId() {
        return talkRoomId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", talkRoomId=" + talkRoomId +
                ", text=" + text +
                '}';
    }
}
