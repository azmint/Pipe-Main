package jp.personal.gi.pipe_api.adapter.interactor.account.find;

import jp.personal.gi.pipe_api.core.usecase.account.*;
import jp.personal.gi.pipe_api.core.usecase.account.find.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class FindAccountInteractorAdapter extends FindAccountInteractor {
    @Autowired
    public FindAccountInteractorAdapter(AccountRepository accountRepository) {
        super(accountRepository);
    }
}
