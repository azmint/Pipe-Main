package jp.personal.gi.pipe_api.core.usecase.account;

import jp.personal.gi.pipe_api.core.entity.account.*;
import jp.personal.gi.pipe_api.core.usecase.*;

public interface AccountRepository {
    Account findBy(AccountId accountId) throws NoEntityWithIdWasFound, ProcessingFailedInDataSource, CouldNotAccessDataSource;

    Account registration(Account account) throws ProcessingFailedInDataSource, CouldNotAccessDataSource;

    AccountId generateId() throws ProcessingFailedInDataSource, CouldNotAccessDataSource;
}
