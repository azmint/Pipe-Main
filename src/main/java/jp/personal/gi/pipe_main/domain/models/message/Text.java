package jp.personal.gi.pipe_main.domain.models.message;

import jp.personal.gi.pipe_main.domain.support.ValueObject;

import java.util.Objects;

public class Text implements ValueObject {
    private final String value;

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(value, text.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Text{" +
                "value='" + value + '\'' +
                '}';
    }
}
