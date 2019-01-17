package jp.personal.gi.pipe_main.domain.models.user;

import jp.personal.gi.pipe_main.domain.models.message.Messages;

import java.util.Objects;
import java.util.stream.Stream;

public class Users {
    private static final Users EMPTY = new Users(Stream.empty());

    private final Stream<User> values;

    private Users(Stream<User> values) {
        this.values = values;
    }

    public static Users empty() {
        return EMPTY;
    }

    public static Users of(Stream<User> values) {
        return new Users(values);
    }

    public Messages toMessages() {
        return Messages.empty();
    }

    public Stream<User> toStream() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(values, users.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Users{" +
                "values=" + values +
                '}';
    }
}
