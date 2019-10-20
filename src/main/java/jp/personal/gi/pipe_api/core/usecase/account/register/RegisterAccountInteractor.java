package jp.personal.gi.pipe_api.core.usecase.account.register;

import jp.personal.gi.pipe_api.core.entity.account.*;
import jp.personal.gi.pipe_api.core.usecase.*;
import jp.personal.gi.pipe_api.core.usecase.account.*;
import jp.personal.gi.pipe_api.core.usecase.account.register.error.*;

public class RegisterAccountInteractor {
    private static final InputDataConstraints INPUT_DATA_CONSTRAINTS = new InputDataConstraints();
    private static final AccountFactory ACCOUNT_FACTORY = new AccountFactory();

    private final AccountRepository accountRepository;

    public RegisterAccountInteractor(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public OutputData handle(InputData inputData) throws RegisterException {
        try {
            INPUT_DATA_CONSTRAINTS.check(inputData);
            final Account account = ACCOUNT_FACTORY.create(this.accountRepository, inputData);
            final Account registeredAccount = this.accountRepository.registration(account);
            return new OutputData(
                    registeredAccount.getId().getStringTypeValue(),
                    registeredAccount.getName().getStringTypeValue(),
                    registeredAccount.getNameReading().getStringTypeValue(),
                    registeredAccount.getAuthority().name());
        } catch (IllegalInputDataException e) {
            throw new RegisterException("入力値が不正です。", e);
        } catch (GenerateIdException e) {
            throw new RegisterException("IDの生成に失敗しました。", e);
        } catch (CouldNotAccessDataSource e) {
            throw new RegisterException("データソースへのアクセスに失敗しました。", e);
        } catch (ProcessingFailedInDataSource e) {
            throw new RegisterException("データソースでの処理中にエラーが発生しました。", e);
        } catch (Exception e) {
            throw new RegisterException("想定外のエラーが発生しました。", e);
        }
    }
}
