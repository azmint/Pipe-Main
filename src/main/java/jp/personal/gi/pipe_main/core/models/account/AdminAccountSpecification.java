package jp.personal.gi.pipe_main.core.models.account;

import jp.personal.gi.pipe_main.core.support.Specification;

public class AdminAccountSpecification implements Specification<Account> {
    @Override
    public boolean isSatisfiedBy(Account account) {
        return account.getAuthority() == Authority.ADMIN;
    }

    public Account create(AccountId id, MailAddress mailAddress, Password password) {
        return new Account(id, mailAddress, password, Authority.ADMIN);
    }
}
