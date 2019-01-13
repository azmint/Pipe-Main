package jp.personal.gi.pipe_main.core.models.talkroom;

import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class TalkRoom extends Entity<TalkRoomId> {
    private final SenderId senderId;
    private final ReceiverId receiverId;

    public TalkRoom(TalkRoomId id, SenderId senderId, ReceiverId receiverId) {
        super(id);
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public SenderId getSenderId() {
        return senderId;
    }

    public ReceiverId getReceiverId() {
        return receiverId;
    }

    @Override
    public String toString() {
        return "TalkRoom{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                '}';
    }
}
