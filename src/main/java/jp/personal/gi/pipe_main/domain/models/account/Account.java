package jp.personal.gi.pipe_main.domain.models.account;

import jp.personal.gi.pipe_main.domain.support.entity.Entity;

public class Account extends Entity<AccountId> {
    private final MailAddress mailAddress;
    private final Password password;
    private final Authority authority;

    public Account(AccountId id, MailAddress mailAddress, Password password, Authority authority) {
        super(id);
        this.mailAddress = mailAddress;
        this.password = password;
        this.authority = authority;
    }

    public MailAddress getMailAddress() {
        return mailAddress;
    }

    public Password getPassword() {
        return password;
    }

    public Authority getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", mailAddress=" + mailAddress +
                ", password=" + password +
                ", authority=" + authority +
                '}';
    }
}
