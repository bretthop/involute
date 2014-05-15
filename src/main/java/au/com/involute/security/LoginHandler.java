package au.com.involute.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import au.com.involute.service.UserAccountService;
import au.com.involute.ui.bean.UserAccountBean;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class LoginHandler implements UserDetailsService
{
    private static final Logger logger = LoggerFactory.getLogger(LoginHandler.class);

    @Resource
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException
    {
        User springUser = null;

        UserAccountBean user = userAccountService.getByUsername(username);

        if (user != null) {
            springUser = SecurityUserWrapper.fromApplicationUser(user, this.getAuthorities(user));
        }
        else {
            logger.warn(String.format("Authentication Failed - No user was found with username '%s'", username));
        }

        return springUser;
    }

    /**
     *  Returns dummy data for now. This matches the role defined in spring-security.xml
     * @param user - The user
     * @return - A list of authorities
     */
    private List<GrantedAuthority> getAuthorities(UserAccountBean user)
    {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        return authList;
    }
}