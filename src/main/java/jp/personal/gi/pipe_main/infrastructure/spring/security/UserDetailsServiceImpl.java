package jp.personal.gi.pipe_main.infrastructure.spring.security;

import jp.personal.gi.pipe_main.domain.models.account.Account;
import jp.personal.gi.pipe_main.domain.models.account.AccountRepository;
import jp.personal.gi.pipe_main.domain.models.account.MailAddress;
import jp.personal.gi.pipe_main.domain.models.account.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final MailAddress mailAddress = new MailAddress(s);
        final Optional<Account> maybeAccount = this.accountRepository.findBy(mailAddress);

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return maybeAccount
                        .map(Account::getPassword)
                        .map(Password::getValue)
                        .orElse(null);
            }

            @Override
            public String getUsername() {
                return maybeAccount
                        .map(Account::getMailAddress)
                        .map(MailAddress::getValue)
                        .orElse(null);
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
