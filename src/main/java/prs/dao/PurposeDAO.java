/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import prs.entity.Purpose;

/**
 *
 * @author Janusz
 */
@Repository
public class PurposeDAO {
    @PersistenceContext	
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Purpose getPurposeByID(int purposeID) {
		String hql = "FROM Purpose as purposes WHERE purposes.purposeID = ?";
		List<Purpose> purpose = entityManager.createQuery(hql)
				.setParameter(1, purposeID).getResultList();
		return purpose.get(0);
	}
}
