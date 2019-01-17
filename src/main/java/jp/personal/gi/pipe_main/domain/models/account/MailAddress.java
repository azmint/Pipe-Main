package jp.personal.gi.pipe_main.domain.models.account;

import jp.personal.gi.pipe_main.domain.support.ValueObject;

import java.util.Objects;

public class MailAddress implements ValueObject {
    private final String value;

    public MailAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress mailAddress = (MailAddress) o;
        return value.equals(mailAddress.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MailAddress{" +
                "value='" + value + '\'' +
                '}';
    }
}
