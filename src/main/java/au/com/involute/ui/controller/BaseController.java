package au.com.involute.ui.controller;

import org.springframework.security.core.Authentication;
import au.com.involute.security.SecurityUserWrapper;
import au.com.involute.ui.bean.UserAccountBean;

import java.security.Principal;

public class BaseController
{
    protected UserAccountBean getUserFromPrincipal(Principal principal)
    {
        UserAccountBean result = null;

        if (principal instanceof Authentication) {
            Object userWrapper = ((Authentication) principal).getPrincipal();

            if (userWrapper instanceof SecurityUserWrapper) {
                result = ((SecurityUserWrapper) userWrapper).getApplicationUser();
            }
        }

        return result;
    }
}
