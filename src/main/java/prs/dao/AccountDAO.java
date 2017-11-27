package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import prs.entity.Account;
import prs.model.LogInData;

@Repository
public class AccountDAO {
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
	@PersistenceContext
	private EntityManager entityManager;
	public void addAccount(Account account) {
		account.setPassword(getPasswordEncoder().encode(account.getPassword()));
		entityManager.persist(account);
	}
	
	public boolean isAccountExists(Account account) {
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
	public Account getAccount(LogInData logInData) throws NonUniqueResultException {
		String hql = "FROM Account as accounts WHERE accounts.username = ? and accounts.password = ?";
		List<Account> account = entityManager.createQuery(hql)
				.setParameter(1, logInData.getUsername())
				.setParameter(2, logInData.getPassword()).getResultList();
		if (account.isEmpty()) {
			throw new NonUniqueResultException();
		}
		else {
			return account.get(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Account getAccount(String username) {
		String hql = "FROM Account as accounts WHERE accounts.username = ?";
		List<Account> account = entityManager.createQuery(hql)
				.setParameter(1, username).getResultList();
		return account.get(0);
	}
}
