package au.com.involute.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class DashboardController extends BaseController
{
    @RequestMapping(method = RequestMethod.GET)
    public String viewDashboard(ModelMap model, Principal principal)
    {
        model.addAttribute("user", this.getUserFromPrincipal(principal));

        return "dashboard";
    }
}