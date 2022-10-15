package com.job.time.tracker.security;


import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean accountEnabled;
	private List<GrantedAuthority> authorities;
	
		
	public MyUserDetails(JUser user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.accountEnabled = user.isEnabled();
		this.accountExpired = user.isAccountExpired();
		this.accountLocked = user.isLockedStatus();
		this.credentialsExpired = user.isPasswordExpired();

		List<UserRole> userRoleList = user.getUserRoles();
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		
		for(UserRole u : userRoleList) {
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(u.getJRole().getRole());
			
			grantedAuthorityList.add(simpleGrantedAuthority);
		}
				
		this.authorities = grantedAuthorityList;
		
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
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
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return !credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return accountEnabled;
	}

	public int getId(){
		return id;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getEmail(){
		return email;
	}
	
}