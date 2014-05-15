package au.com.involute.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import au.com.involute.service.UserAccountService;
import au.com.involute.ui.bean.UserAccountBean;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController extends BaseController
{
    @Resource
    UserAccountService userAccountService;

    @RequestMapping(value = "/login")
    public String viewLoginPage()
    {
        return "login";
    }

    @RequestMapping(value = "/loginFailure")
    public @ResponseBody String displayLoginFailureMessage()
    {
        return "Login has failed, go back and try again.";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public @ResponseBody String signUp(@Valid UserAccountBean user, BindingResult bindingResult, HttpServletResponse response)
    {
        String result = null;

        if (!bindingResult.hasErrors()) {
            userAccountService.createUser(user);

            result = "User created, go back and log it.";
        }
        else {
            response.setStatus(400);

            result = "You shall not pass! (Error).<br><br>";
            result += bindingResult.toString();
        }

        return result;
    }
}
