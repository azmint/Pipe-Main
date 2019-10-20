package jp.personal.gi.pipe_api.adapter.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.util.matcher.*;

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
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
        private final UserDetailsServiceImpl userDetailsService;

        @Autowired
        public AuthenticationConfiguration(UserDetailsServiceImpl userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }
    }
}
