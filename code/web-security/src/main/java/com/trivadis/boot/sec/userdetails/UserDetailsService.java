package com.trivadis.boot.sec.userdetails;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	private static final String PREFIX = "ROLE_";
	private static final List<String> ALLOWED_USERS = Arrays.asList("els", "dba");

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (!ALLOWED_USERS.contains(username)) {
			throw new UsernameNotFoundException("username " + username + " not found.");
		}

		return new org.springframework.security.core.userdetails.User(username, username,
				Arrays.asList(new SimpleGrantedAuthority(PREFIX + "USER"),
						new SimpleGrantedAuthority(PREFIX + "ADMIN")));
	}

}
