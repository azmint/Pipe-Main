package jp.personal.gi.pipe_main.domain.models.account;

import jp.personal.gi.pipe_main.domain.support.entity.EntityId;

import java.util.Objects;

public class AccountId implements EntityId {
    private final String value;

    public AccountId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return value.equals(accountId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "value='" + value + '\'' +
                '}';
    }
}
