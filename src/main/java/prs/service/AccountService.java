package prs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import prs.dao.AccountDAO;
import prs.entity.Account;

@Transactional
@Service
public class AccountService {
	@Autowired 
	private AccountDAO accountDAO;
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    public void save(Account account){
        account.setPassword(getPasswordEncoder().encode(account.getPassword()));
        accountDAO.addAccount(account);
    }
}
