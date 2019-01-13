package jp.personal.gi.pipe_main.core.models.message;

import jp.personal.gi.pipe_main.core.support.entity.EntityId;

import java.util.Objects;

public class MessageId implements EntityId {
    private final String value;

    public MessageId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageId messageId = (MessageId) o;
        return Objects.equals(value, messageId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MessageId{" +
                "value='" + value + '\'' +
                '}';
    }
}
