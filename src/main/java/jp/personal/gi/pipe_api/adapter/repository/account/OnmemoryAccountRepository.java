package jp.personal.gi.pipe_api.adapter.repository.account;

import jp.personal.gi.pipe_api.core.entity.account.*;
import jp.personal.gi.pipe_api.core.usecase.*;
import jp.personal.gi.pipe_api.core.usecase.account.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class OnmemoryAccountRepository implements AccountRepository {
    private static int NEXT_NO = 0;

    private final Map<AccountId, Account> map = new HashMap<>();

    public OnmemoryAccountRepository() {
        final AccountId accountId = new AccountId(Integer.toString(NEXT_NO++));
        final Account account = new Account(accountId, new Name("root"), new NameReading("root"), Authority.ADMIN);
        this.map.put(accountId, account);
    }

    @Override
    public Account findBy(AccountId accountId) throws NoEntityWithIdWasFound, ProcessingFailedInDataSource, CouldNotAccessDataSource {
        int intAccountId = Integer.valueOf(accountId.getStringTypeValue());
        if (intAccountId == 0) return this.map.get(accountId);
        int remainder = intAccountId % 3;
        if (remainder == 0) throw new ProcessingFailedInDataSource("内部処理エラー");
        if (remainder == 2) throw new CouldNotAccessDataSource("アクセスエラー");
        if (!this.map.containsKey(accountId)) throw new NoEntityWithIdWasFound("エンティティが存在しません。");
        return this.map.get(accountId);
    }

    @Override
    public Account registration(Account account) throws ProcessingFailedInDataSource, CouldNotAccessDataSource {
        int intAccountId = Integer.valueOf(account.getId().getStringTypeValue());
        int remainder = intAccountId % 3;
        if (remainder == 0) throw new ProcessingFailedInDataSource("内部処理エラー");
        if (remainder == 2) throw new CouldNotAccessDataSource("アクセスエラー");
        this.map.put(account.getId(), account);
        return account;
    }

    @Override
    public AccountId generateId() throws ProcessingFailedInDataSource, CouldNotAccessDataSource {
        int nextNo = NEXT_NO++;
        int remainder = nextNo % 3;
        if (remainder == 0) throw new ProcessingFailedInDataSource("内部処理エラー");
        if (remainder == 2) throw new CouldNotAccessDataSource("内部処理エラー");
        return new AccountId(Integer.toString(nextNo));
    }
}
