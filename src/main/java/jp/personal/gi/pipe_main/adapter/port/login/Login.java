package jp.personal.gi.pipe_main.adapter.port.login;

import jp.personal.gi.pipe_main.core.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/login")
public class Login {
    private final UserRepository userRepository;

    @Autowired
    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("")
    public String login() {
        return "login/login.html";
    }
}
