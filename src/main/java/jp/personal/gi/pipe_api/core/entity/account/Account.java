package jp.personal.gi.pipe_api.core.entity.account;

import jp.personal.gi.pipe_api.core.entity.*;

import java.util.*;

public class Account implements Entity<Account, AccountId> {
    private final AccountId accountId;
    private final Name name;
    private final NameReading nameReading;
    private final Authority authority;

    public Account(AccountId accountId, Name name, NameReading nameReading, Authority authority) {
        this.accountId = accountId;
        this.name = name;
        this.nameReading = nameReading;
        this.authority = authority;
    }

    public Name getName() {
        return name;
    }

    public NameReading getNameReading() {
        return nameReading;
    }

    public Authority getAuthority() {
        return authority;
    }

    @Override
    public AccountId getId() {
        return this.accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
                Objects.equals(name, account.name) &&
                Objects.equals(nameReading, account.nameReading) &&
                authority == account.authority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, nameReading, authority);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name=" + name +
                ", nameReading=" + nameReading +
                ", authority=" + authority +
                '}';
    }
}
