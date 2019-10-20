package jp.personal.gi.pipe_api.core.usecase.account.find;

import jp.personal.gi.pipe_api.core.entity.account.*;
import jp.personal.gi.pipe_api.core.usecase.*;
import jp.personal.gi.pipe_api.core.usecase.account.*;

public class FindAccountInteractor {
    private final AccountRepository accountRepository;

    public FindAccountInteractor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public OutputData handle(String inputData) throws FindException {
        try {
            final AccountId accountId = new AccountId(inputData);
            final Account account = this.accountRepository.findBy(accountId);
            return new OutputData(
                    account.getId().getStringTypeValue(),
                    account.getName().getStringTypeValue(),
                    account.getNameReading().getStringTypeValue(),
                    account.getAuthority().name());
        } catch (NoEntityWithIdWasFound e) {
            throw new FindException("IDに該当するエンティティが見つかりませんでした。", e);
        } catch (CouldNotAccessDataSource e) {
            throw new FindException("データソースにアクセスできませんでした。", e);
        } catch (ProcessingFailedInDataSource e) {
            throw new FindException("データソースでの処理中にエラーが発生しました。", e);
        } catch (Exception e) {
            throw new FindException("想定外のエラーが発生しました。", e);
        }
    }
}
