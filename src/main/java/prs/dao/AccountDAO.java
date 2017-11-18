package prs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Account;

@Repository
public class AccountDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public void addAccount(Account account) {
		entityManager.persist(account);
	}
	public boolean isAccountExists(Account account) {
		String hql = "FROM Account as accounts WHERE accounts.login = ? or accounts.email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, account.getLogin())
				.setParameter(2, account.getEmail()).getResultList().size();
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
