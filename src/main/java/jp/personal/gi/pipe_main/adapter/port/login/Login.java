package jp.personal.gi.pipe_main.adapter.port.login;

import jp.personal.gi.pipe_main.core.models.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/login")
public class Login {
    private final AccountRepository userRepository;

    @Autowired
    public Login(AccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("")
    public String login() {
        return "login/login.html";
    }
}
