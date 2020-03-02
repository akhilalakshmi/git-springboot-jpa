/*package com.example.assignment.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class ApplicationUser implements UserDetails{
	
	public ApplicationUser(List<? extends GrantedAuthority> grantedAuthorities, 
			String username, 
			String password,
			boolean isAccountNonExpired, 
			boolean isCredentialsNonExpired, 
			boolean isEnabled,
			boolean isAccountNonLocked) {
		super();
		this.grantedAuthorities = grantedAuthorities;
		this.username = username;
		this.password = password;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
		this.isAccountNonLocked = isAccountNonLocked;
	}

	private final List <? extends GrantedAuthority> grantedAuthorities;
	private final String username;
	private final String password;
	private final boolean isAccountNonExpired;
	private final boolean isCredentialsNonExpired;
	private final boolean isEnabled;
	private final boolean isAccountNonLocked;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}
*/