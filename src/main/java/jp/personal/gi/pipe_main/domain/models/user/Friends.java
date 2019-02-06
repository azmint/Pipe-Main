package jp.personal.gi.pipe_main.domain.models.user;

import jp.personal.gi.pipe_main.domain.support.*;

import java.util.*;

public class Friends implements ValueObject {
    private static final Friends EMPTY = new Friends(Collections.emptyList());

    private final List<UserId> values;

    public Friends(List<UserId> values) {
        this.values = values;
    }

    public static Friends empty() {
        return EMPTY;
    }

    public List<UserId> getValues() {
        return values;
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
