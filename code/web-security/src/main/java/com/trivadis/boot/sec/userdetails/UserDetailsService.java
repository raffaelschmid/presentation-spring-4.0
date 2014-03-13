package com.trivadis.boot.sec.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@ConditionalOnMissingBean(org.springframework.security.core.userdetails.UserDetailsService.class)
public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	private static final String PREFIX = "ROLE_";
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		System.out.println(this.getClass().getClassLoader());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("username " + username + " not found.");
		}

		return new org.springframework.security.core.userdetails.User(user.getName(),
				user.getPassword(), mapRole(roleRepository.findAllByUser(user)));
	}

	private Collection<? extends GrantedAuthority> mapRole(List<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(PREFIX + role.getName()));
		}
		return authorities;
	}

}
