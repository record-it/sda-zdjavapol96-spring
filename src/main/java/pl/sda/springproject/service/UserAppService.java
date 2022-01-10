package pl.sda.springproject.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.springproject.repository.UserAppRepository;

@Service
public class UserAppService implements UserDetailsService {
    private final UserAppRepository users;

    public UserAppService(UserAppRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByEmail(username).orElse(null);
    }
}
