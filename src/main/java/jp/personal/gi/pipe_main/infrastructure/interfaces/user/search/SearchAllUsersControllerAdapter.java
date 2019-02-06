package jp.personal.gi.pipe_main.infrastructure.interfaces.user.search;

import jp.personal.gi.pipe_main.application.user.search.*;
import jp.personal.gi.pipe_main.interfaces.user.*;
import jp.personal.gi.pipe_main.interfaces.user.search.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("user/search")
@Controller
public class SearchAllUsersControllerAdapter extends SearchAllUsersController {
    @Autowired
    public SearchAllUsersControllerAdapter(SearchAllUsersService searchAllUsersService) {
        super(searchAllUsersService);
    }

    @RequestMapping("/")
    public String apply(Model model) {
        final List<UserRecord> userRecords = this.get();
        model.addAttribute("users", userRecords);
        return "user/search/list";
    }
}
