package com.quiz.authentication;

import com.quiz.dao.IUserDao;
import com.quiz.entities.User;
import com.quiz.service.impl.AuthenticationContext;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;


public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    
    private IUserDao userDao;
    
    public UsernamePasswordAuthenticationProvider(IUserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        User user=userDao.getUserByName(a.getName());
        if(user==null){
            return null;
        }
        System.out.println(a.getCredentials());
        System.out.println(a.getName()+" trying to log in");
        if(user.getPassword().equals(a.getCredentials())){
            List<GrantedAuthority> grantedAuths=new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth=new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword(), grantedAuths);
            
            return auth;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(UsernamePasswordAuthenticationToken.class);
    }
	
}
