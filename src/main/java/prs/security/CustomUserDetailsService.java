package prs.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import prs.dao.AccountDAO;
import prs.entity.Account;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account account = accountDAO.getAccount(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(account.getRole());
		UserDetails userDetails = (UserDetails)new User(account.getUsername(),
				account.getPassword(), Arrays.asList(authority));
		return userDetails;
	}
}

