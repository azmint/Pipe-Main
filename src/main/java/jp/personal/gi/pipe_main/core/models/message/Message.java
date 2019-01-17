package jp.personal.gi.pipe_main.core.models.message;

import jp.personal.gi.pipe_main.core.models.talkroom.TalkRoomId;
import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class Message extends Entity<MessageId> {
    private final TalkRoomId talkRoomId;
    private final SenderId senderId;
    private final Text text;

    public Message(MessageId id, TalkRoomId talkRoomId, SenderId senderId, Text text) {
        super(id);
        this.talkRoomId = talkRoomId;
        this.senderId = senderId;
        this.text = text;
    }

    public TalkRoomId getTalkRoomId() {
        return talkRoomId;
    }

    public SenderId getSenderId() {
        return senderId;
    }

    public Text getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", talkRoomId=" + talkRoomId +
                ", senderId=" + senderId +
                ", text=" + text +
                '}';
    }
}
