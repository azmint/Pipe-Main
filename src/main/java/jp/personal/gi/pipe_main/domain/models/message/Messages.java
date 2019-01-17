package jp.personal.gi.pipe_main.domain.models.message;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Messages {
    private static final Messages EMPTY = new Messages(Stream.empty());

    private final Stream<Message> values;

    private Messages(Stream<Message> values) {
        this.values = values;
    }

    public static Messages empty() {
        return EMPTY;
    }

    public Optional<Message> findBy(MessageId id) {
        return this.values.filter(value -> value.matches(id)).findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messages Messages = (Messages) o;
        return Objects.equals(values, Messages.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Messages{" +
                "values=" + values +
                '}';
    }
}
