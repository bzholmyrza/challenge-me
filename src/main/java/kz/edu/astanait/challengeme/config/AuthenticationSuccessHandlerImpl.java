package kz.edu.astanait.challengeme.config;


import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
    private UserRepository accountRepository;

    @Autowired
    public AuthenticationSuccessHandlerImpl(UserRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userEmail = "";
        if(authentication.getPrincipal() instanceof Principal) {
            userEmail = ((Principal)authentication.getPrincipal()).getName();

        }else {
            userEmail = ((User)authentication.getPrincipal()).getEmail();
        }
        User account = accountRepository.findByEmail(userEmail);
        httpServletRequest.getSession().setAttribute("user", account);
        httpServletResponse.sendRedirect("/home");
    }
}
