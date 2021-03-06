package com.template.security.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.model.User;
import com.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/4/21
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ObjectMapper mapper;

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, UserNamePasswordErrorException {
        if (userName.equals("admin")) {
            User role_admin = User.builder()
                    .id(UUID.fromString("08e8b690-e274-41c1-ad7a-97f56a1b3f86"))
                    .userName("admin")
                    .email("admin@ganker.com")
                    .roles("ROLE_ADMIN")
                    .active(true)
                    .locked(false)
                    .accountExpiredDate(LocalDate.now().plusYears(1))
                    .credentialsExpiredDate(LocalDate.now().plusYears(1))
                    .password("$2a$10$/7mgHXzTtY9Vjd/pORN0DOCIPugrQOc/ghzTXiW9.F1pH4fKf3f3u")
                    .build();
            return UserFactory.create(role_admin);
        }
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            return UserFactory.create(userOptional.get());
        } else {
            String message = new String();
            try {
                message = mapper.writeValueAsString(new AuthenticationFailureResponse());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            throw new UserNamePasswordErrorException(message);
        }
    }
}
