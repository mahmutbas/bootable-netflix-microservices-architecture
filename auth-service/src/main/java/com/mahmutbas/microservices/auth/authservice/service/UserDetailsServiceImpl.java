package com.mahmutbas.microservices.auth.authservice.service;

import com.mahmutbas.microservices.auth.authservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        final List<User> users = Arrays.asList(
                new User(1L, "mahmut", encoder.encode("bas"), "USER"),
                new User(2L, "admin", encoder.encode("passwd"), "ADMIN")
        );

        Optional<User> filteredUser = users.stream().filter(usrnm -> usrnm.getUsername().equals(username)).findAny();
        if (filteredUser.isPresent())
        {
            //Spring roles start with ROLE_xxx. Convertion to string
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_" + filteredUser.get().getRole());

            return new org.springframework.security.core.userdetails.User(filteredUser.get().getUsername(), filteredUser.get().getPassword(), grantedAuthorities);
        }
        else
        {
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }
    }

}
