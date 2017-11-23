package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import prs.entity.Account;

@Repository
public class AccountDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public void addAccount(Account account) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		account.setPassword(encoder.encode(account.getPassword()));
		entityManager.persist(account);
	}
	public boolean isAccountExists(Account account) {
		String hql = "FROM Account as accounts WHERE accounts.username = ? or accounts.email = ?";
		int count = entityManager.createQuery(hql)
				.setParameter(1, account.getUsername())
				.setParameter(2, account.getEmail()).getResultList().size();
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	@SuppressWarnings("unchecked")
	public Account getAccount(String username) {
		String hql = "FROM Account as accounts WHERE accounts.username=?";
		List<Account> account = entityManager.createQuery(hql)
				.setParameter(1, username).getResultList();
		return account.get(0);
	}
}
