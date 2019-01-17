package jp.personal.gi.pipe_main.domain.models.account;

import jp.personal.gi.pipe_main.domain.support.repository.IdentifierGeneratable;
import jp.personal.gi.pipe_main.domain.support.repository.Repository;
import jp.personal.gi.pipe_main.domain.support.repository.Storable;

import java.util.Optional;

public interface AccountRepository extends
        Repository<AccountId, Account>,
        Storable<Account>,
        IdentifierGeneratable<AccountId> {
    Optional<Account> findBy(MailAddress mailAddress);
}
