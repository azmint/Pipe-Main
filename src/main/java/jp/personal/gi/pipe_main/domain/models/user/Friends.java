package jp.personal.gi.pipe_main.domain.models.user;

import jp.personal.gi.pipe_main.domain.support.ValueObject;

import java.util.Objects;
import java.util.stream.Stream;

public class Friends implements ValueObject {
    private final Stream<UserId> values;

    public Friends(Stream<UserId> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(values, friends.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Friends{" +
                "values=" + values +
                '}';
    }
}
