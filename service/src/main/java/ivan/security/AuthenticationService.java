package ivan.security;

import ivan.dao.SecurityDao;
import ivan.pojo.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings({"unused"})
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    SecurityDao securityDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            List<Security> securities = securityDao.findByLogin(login);
            if (securities.size() != 1) {
                throw new UsernameNotFoundException("Login not found: " + login);
            }
            Security security = securities.get(0);
            return new User(
                    security.getLogin(),
                    security.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(security.getRole()))
            );

        } catch (Exception e) {
            throw new UsernameNotFoundException("Login not found: " + login, e);
        }
    }
}
