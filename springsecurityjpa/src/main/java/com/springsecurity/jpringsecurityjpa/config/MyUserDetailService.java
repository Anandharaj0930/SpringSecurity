package com.springsecurity.jpringsecurityjpa.config;

import com.springsecurity.jpringsecurityjpa.repository.User;
import com.springsecurity.jpringsecurityjpa.repository.UserRepository;
import com.springsecurity.jpringsecurityjpa.types.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("user not found for the user " + userName));
        return user.map(MyUserDetails::new).get();
    }
}
