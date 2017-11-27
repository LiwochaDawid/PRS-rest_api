package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import prs.entity.Account;

@Repository
public class AccountDAO {
	@PersistenceContext
	private EntityManager entityManager;	
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
	public void addAccount(Account account) {
		account.setPassword(getPasswordEncoder().encode(account.getPassword()));
		entityManager.persist(account);
	}
	
	public boolean isUsernameExists(Account account) {
		String hql = "FROM Account as accounts WHERE accounts.username = ?";
		int count = entityManager.createQuery(hql)
				.setParameter(1, account.getUsername())
				.getResultList().size();
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Account getAccountByUsername(String username) {
		String hql = "FROM Account as accounts WHERE accounts.username = ?";
		List<Account> account = entityManager.createQuery(hql)
				.setParameter(1, username).getResultList();
		return account.get(0);
	}
}
