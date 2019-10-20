package jp.personal.gi.pipe_api.adapter.interactor.account.register;

import jp.personal.gi.pipe_api.core.usecase.account.*;
import jp.personal.gi.pipe_api.core.usecase.account.register.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class RegisterAccountInteractorAdapter extends RegisterAccountInteractor {
    @Autowired
    public RegisterAccountInteractorAdapter(AccountRepository accountRepository) {
        super(accountRepository);
    }
}
