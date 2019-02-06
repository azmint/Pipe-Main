package jp.personal.gi.pipe_main.domain.models.account;

import java.util.*;

public class Accounts {
    private static final Accounts EMPTY = new Accounts(Collections.emptyList());

    private final List<Account> values;

    private Accounts(List<Account> values) {
        this.values = values;
    }

    public static Accounts empty() {
        return EMPTY;
    }

    public static Accounts of(List<Account> values) {
        return new Accounts(values);
    }

    public List<Account> toList() {
        return this.values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return values.equals(accounts.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "values=" + values +
                '}';
    }
}
