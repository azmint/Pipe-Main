package jp.personal.gi.pipe_main.domain.models.message;

import jp.personal.gi.pipe_main.domain.models.user.UserId;
import jp.personal.gi.pipe_main.domain.support.ValueObject;

import java.util.Objects;

public class SenderId implements ValueObject {
    private final UserId userId;

    public SenderId(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SenderId senderId = (SenderId) o;
        return userId.equals(senderId.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "SenderId{" +
                "userId=" + userId +
                '}';
    }
}
