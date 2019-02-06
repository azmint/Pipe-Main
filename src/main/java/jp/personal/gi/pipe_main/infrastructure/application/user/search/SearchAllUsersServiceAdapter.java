package jp.personal.gi.pipe_main.infrastructure.application.user.search;

import jp.personal.gi.pipe_main.application.user.search.*;
import jp.personal.gi.pipe_main.domain.models.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class SearchAllUsersServiceAdapter extends SearchAllUsersService {
    @Autowired
    public SearchAllUsersServiceAdapter(UserRepository repository) {
        super(repository);
    }
}
