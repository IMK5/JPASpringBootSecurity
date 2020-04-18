package imk.tn.JPASpringBootSecurity.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imk.tn.JPASpringBootSecurity.model.Role;
import imk.tn.JPASpringBootSecurity.model.User;
import imk.tn.JPASpringBootSecurity.repository.UserRepository;


@Service
public class MyUserDetailService implements UserDetailsService{

	
	@Autowired
    private UserRepository userRepository;

	
	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
		Optional<User> user = userRepository.findByUserName(username);
		// if user not found throw exception
        user.orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND :"+username));
        
             
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(),
                user.get().getPassword(),
                mapRolesToAuthorities(user.get().getRoles()));
    }
	
	
	
	 private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
	                .collect(Collectors.toList());
	    }
	

}
