package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}

