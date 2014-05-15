package au.com.involute.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import au.com.involute.ui.bean.UserAccountBean;

import java.util.Collection;
import java.util.List;

public class SecurityUserWrapper extends User
{
    private UserAccountBean applicationUser;

    public SecurityUserWrapper(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserAccountBean getApplicationUser()
    {
        return applicationUser;
    }

    public void setApplicationUser(UserAccountBean applicationUser)
    {
        this.applicationUser = applicationUser;
    }

    public static SecurityUserWrapper fromApplicationUser(UserAccountBean applicationUser, List<GrantedAuthority> authorities)
    {
        SecurityUserWrapper userWrapper = new SecurityUserWrapper(
                applicationUser.getUsername(),
                applicationUser.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

        userWrapper.setApplicationUser(applicationUser);

        return userWrapper;
    }
}