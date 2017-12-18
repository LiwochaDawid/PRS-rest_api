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
import prs.entity.Visit;

/**
 *
 * @author Janusz
 */
@Repository
public class VisitDAO {
    @PersistenceContext	
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Visit> getAllVisits(){
        String hql = "FROM Visit as visits ORDER BY visits.visitID";
		return (List<Visit>) entityManager.createQuery(hql).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Visit> getThisDoctorVisits(String name){
        String hql = "FROM Visit as visits WHERE visits.doctor.account.username=? ORDER BY visits.visitID";
        List<Visit> visits = entityManager.createQuery(hql)
				.setParameter(1, name).getResultList();
		return visits;
    }
    
    @SuppressWarnings("unchecked")
	public List<Visit> getThisDoctorFutureVisits(String name){
        String hql = "FROM Visit as visits WHERE visits.doctor.account.username = ? AND visits.date > ? ORDER BY visits.date";
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        List<Visit> visits = entityManager.createQuery(hql)
				.setParameter(1, name)
				.setParameter(2, date)
				.getResultList();
		return visits;
    }
}
