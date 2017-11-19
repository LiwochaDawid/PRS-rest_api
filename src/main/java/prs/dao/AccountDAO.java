package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Account;
import prs.model.LogInData;

@Repository
public class AccountDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public void addAccount(Account account) {
		entityManager.persist(account);
	}
	public boolean isAccountExists(Account account) {
		String hql = "FROM Account as accounts WHERE accounts.login = ? or accounts.email = ?";
		int count = entityManager.createQuery(hql)
				.setParameter(1, account.getLogin())
				.setParameter(2, account.getEmail()).getResultList().size();
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	@SuppressWarnings("unchecked")
	public Account getAccount(LogInData logInData) throws NonUniqueResultException {
		String hql = "FROM Account as accounts WHERE (accounts.login = ? or accounts.email = ?) "
				+ "and accounts.password = ?";
		List<Account> account = entityManager.createQuery(hql)
				.setParameter(1, logInData.getUsername())
				.setParameter(2, logInData.getUsername())
				.setParameter(3, logInData.getPassword()).getResultList();
		if (account.isEmpty()) {
			throw new NonUniqueResultException();
		}
		else {
			return account.get(0);
		}
	}
}
