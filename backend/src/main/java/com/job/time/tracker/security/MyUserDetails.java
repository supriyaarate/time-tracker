package com.job.time.tracker.security;


import com.job.time.tracker.entity.JUser;
import com.job.time.tracker.entity.RoleUser;
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
	private Boolean accountExpired;
	private Boolean accountLocked;
	private Boolean credentialsExpired;
	private Boolean accountEnabled;
	private List<GrantedAuthority> authorities;
	
		
	public MyUserDetails(JUser user) {
		this.id = user.getId();
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.accountEnabled = user.getEnabled();
		this.accountExpired = user.getAccountNonExpired();
		this.accountLocked = user.getAccountNonLocked();
		this.credentialsExpired = user.getCredentialsNonExpired();

		List<RoleUser> userRoleList = user.getRoleUsers();
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		
		for(RoleUser u : userRoleList) {
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(u.getJRole().getRoleName());
			
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