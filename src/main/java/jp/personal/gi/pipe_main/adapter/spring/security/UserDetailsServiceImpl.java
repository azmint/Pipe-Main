package jp.personal.gi.pipe_main.adapter.spring.security;

import jp.personal.gi.pipe_main.core.models.user.ContactInformation;
import jp.personal.gi.pipe_main.core.models.user.Password;
import jp.personal.gi.pipe_main.core.models.user.User;
import jp.personal.gi.pipe_main.core.models.user.UserRepository;
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
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ContactInformation contactInformation = new ContactInformation(s);
        Optional<User> maybeUser = this.userRepository.findBy(contactInformation);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return maybeUser
                        .map(User::getPassword)
                        .map(Password::getValue)
                        .orElse(null);
            }

            @Override
            public String getUsername() {
                return maybeUser
                        .map(User::getContactInformation)
                        .map(ContactInformation::getValue)
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
