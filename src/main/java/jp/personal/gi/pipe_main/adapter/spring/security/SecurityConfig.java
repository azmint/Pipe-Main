package jp.personal.gi.pipe_main.adapter.spring.security;

import jp.personal.gi.pipe_main.core.models.account.*;
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
        private final UserDetailsServiceImpl userDetailsService;
        private final AccountRepository accountRepository;
        private final AdminAccountSpecification adminAccountSpecification;

        @Autowired
        public AuthenticationConfiguration(UserDetailsServiceImpl userDetailsService, AccountRepository accountRepository, AdminAccountSpecification adminAccountSpecification) {
            this.userDetailsService = userDetailsService;
            this.accountRepository = accountRepository;
            this.adminAccountSpecification = adminAccountSpecification;
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder);

            final AccountId id = this.accountRepository.nextId();
            final MailAddress mailAddress = new MailAddress("root@example.jp");
            final Password password = new Password(passwordEncoder.encode("root"));
            final Account rootAccount = adminAccountSpecification.create(id, mailAddress, password);
            this.accountRepository.store(rootAccount);
        }
    }
}
