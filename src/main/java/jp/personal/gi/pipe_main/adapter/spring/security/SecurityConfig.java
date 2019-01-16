package jp.personal.gi.pipe_main.adapter.spring.security;

import jp.personal.gi.pipe_main.core.models.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 認証が必要となるURLを設定します
                // ↓追加
                .antMatchers("/login").permitAll() // /loginFormは認証不要
                // ↑追加
                .antMatchers("/account/**").permitAll() // /account以下のURLも認証不要
                .anyRequest().authenticated() // それ以外はすべて認証された状態じゃなきゃダメだよ〜
                .and()
                .formLogin() // ログインページに飛ばすよ
                .loginProcessingUrl("/login") // ログイン処理をするURL
                .loginPage("/login") // ログインページのURL
                .defaultSuccessUrl("/") // 認証成功時の遷移先
                .failureUrl("/login/?error") // ログイン処理失敗時の遷移先
                .usernameParameter("email")
                .passwordParameter("password");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理を起動させるパス
                .logoutSuccessUrl("/"); // ログアウト完了時のパス
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/*.html", "/*.css")
                .antMatchers("/bootstrap/**")
                .antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

    @Configuration
    protected static class AuthenticationConfiguration
            extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        UserDetailsServiceImpl userDetailsService;

        @Autowired
        UserRepository userRepository;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder);
            this.userRepository.store(new User(
                    new UserId(String.valueOf(9999L)),
                    new UserName("root"),
                    new ContactInformation("root@example.jp"),
                    new Password(passwordEncoder.encode("root")),
                    new Friends(Stream.empty())
            ));
        }
    }
}
