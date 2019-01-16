package jp.personal.gi.pipe_main.adapter.port.user.search;

import jp.personal.gi.pipe_main.core.services.user.search.SearchAllUsersService;
import jp.personal.gi.pipe_main.port.user.UserRecord;
import jp.personal.gi.pipe_main.port.user.search.SearchAllUsersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@EnableAutoConfiguration
@ComponentScan("jp.personal.gi.pipe_main.adapter")
public class SearchAllUsersControllerAdapter extends SearchAllUsersController {
    @Autowired
    public SearchAllUsersControllerAdapter(SearchAllUsersService searchAllUsersService) {
        super(searchAllUsersService);
    }

    @RequestMapping("user/search/all")
    @Override
    public Stream<UserRecord> get() {
        return super.get();
    }
}
