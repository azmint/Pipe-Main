package jp.personal.gi.pipe_main.adapter.core.services.user.search;

import jp.personal.gi.pipe_main.core.models.user.UserRepository;
import jp.personal.gi.pipe_main.core.services.user.search.SearchAllUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchAllUsersServiceAdapter extends SearchAllUsersService {
    @Autowired
    public SearchAllUsersServiceAdapter(UserRepository repository) {
        super(repository);
    }
}
