package jp.personal.gi.pipe_main.core.models.account;

import java.util.Objects;
import java.util.stream.Stream;

public class Accounts {
    private static final Accounts EMPTY = new Accounts(Stream.empty());

    private final Stream<Account> values;

    private Accounts(Stream<Account> values) {
        this.values = values;
    }

    public static Accounts empty() {
        return EMPTY;
    }

    public static Accounts of(Stream<Account> values) {
        return new Accounts(values);
    }

    public Stream<Account> toStream() {
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
