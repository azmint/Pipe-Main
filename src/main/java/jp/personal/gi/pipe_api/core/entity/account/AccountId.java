package jp.personal.gi.pipe_api.core.entity.account;

import java.util.*;

public class AccountId {
    private final String value;

    public AccountId(String value) {
        this.value = value;
    }

    public String getStringTypeValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AccountId accountId = (AccountId) o;
        return Objects.equals(value, accountId.value);
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
