package com.example.securityassignment.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Users implements UserDetails{
	

 public CustomUserDetails(final Users users) {
	 				
	 super(users);
		
			}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
	      /*     getRoles()
								.stream()
								.map(role->new SimpleGrantedAuthority(role.getRolename()))
								.collect(Collectors.toList());*/
	            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	            
	            for(Role role : getRoles()){
	                authorities.add(new SimpleGrantedAuthority(role.getRolename()));
	            }
	        
	            return authorities;
	}
   

	@Override
	public String getPassword() {
	
		return super.getPassword();
	}

	@Override
	public String getUsername() {
			return super.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
			return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
			return true;
	}

	@Override
	public boolean isEnabled() {
			return true;
	}

}
