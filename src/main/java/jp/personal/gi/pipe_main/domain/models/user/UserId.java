package jp.personal.gi.pipe_main.domain.models.user;

import jp.personal.gi.pipe_main.domain.support.entity.EntityId;

import java.util.Objects;

public class UserId implements EntityId {
    private final String value;

    public UserId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(value, userId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserId{" +
                "value='" + value + '\'' +
                '}';
    }
}
