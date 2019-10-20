package jp.personal.gi.pipe_api.core.usecase.account.register;

import jp.personal.gi.pipe_api.core.entity.account.*;
import jp.personal.gi.pipe_api.core.usecase.*;
import jp.personal.gi.pipe_api.core.usecase.account.*;
import jp.personal.gi.pipe_api.core.usecase.account.register.error.*;

public class AccountFactory {
    public Account create(AccountRepository accountRepository, InputData inputData) throws GenerateIdException {
        final AccountId accountId;
        try {
            accountId = accountRepository.generateId();
        } catch (ProcessingFailedInDataSource | CouldNotAccessDataSource e) {
            throw new GenerateIdException("IDの生成に失敗しました。", e);
        }
        return new Account(accountId, new Name(inputData.getName()), new NameReading(inputData.getNameReading()), Authority.values()[inputData.getAuthority()]);
    }
}
