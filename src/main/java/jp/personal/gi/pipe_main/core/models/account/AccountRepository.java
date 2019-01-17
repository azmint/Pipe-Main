package jp.personal.gi.pipe_main.core.models.account;

import jp.personal.gi.pipe_main.core.support.repository.IdentifierGeneratable;
import jp.personal.gi.pipe_main.core.support.repository.Repository;
import jp.personal.gi.pipe_main.core.support.repository.Storable;

import java.util.Optional;

public interface AccountRepository extends
        Repository<AccountId, Account>,
        Storable<Account>,
        IdentifierGeneratable<AccountId> {
    Optional<Account> findBy(MailAddress mailAddress);
}
