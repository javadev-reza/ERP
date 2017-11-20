package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.T_Auth;
import com.microservice.erp2017.service.repo.AuthRepo;
import com.microservice.erp2017.util.CommonUtil;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService implements UserDetailsService {
    
    @Autowired 
    private AuthRepo authRepo;
    
    private final AccountStatusUserDetailsChecker 
            detailsChecker = new AccountStatusUserDetailsChecker();

    public UserService() {
        super();
    }
    
    @Override
    public final User loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails;
        
        T_Auth auth = authRepo.loadUserByUsername(username);
        if(CommonUtil.isNullOrEmpty(auth)) {
            throw new UsernameNotFoundException("user not found");
        } else{
            GrantedAuthority authority = new SimpleGrantedAuthority("USER");
            userDetails = (UserDetails) new User(auth.getUserName(), auth.getPassword(), Arrays.asList(authority));
            detailsChecker.check(userDetails);
        }
        return (User) userDetails;
    }
}
