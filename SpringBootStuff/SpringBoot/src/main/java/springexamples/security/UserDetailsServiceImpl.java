package springexamples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Grabs user/pass info from the database and sends to Spring Security for authentication
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found.");
        }

        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // Load user roles from database by userId
        List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());

        // Turns userRoles into spring security roles
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        // Returns a spring security user object w/ all the information we gathered. Used by spring security to auth
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);

    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }
}
