package jp.personal.gi.pipe_main.core.models.user;

import jp.personal.gi.pipe_main.core.support.ValueObject;

import java.util.Objects;

public class UserName implements ValueObject {
    private final String value;

    public UserName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserName{" +
                "value='" + value + '\'' +
                '}';
    }
}
