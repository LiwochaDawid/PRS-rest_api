package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Doctor;

@Repository
public class DoctorDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Doctor> getAllDoctors() {
		String hql = "FROM Doctor as doctors ORDER BY doctors.doctorID";
		return (List<Doctor>) entityManager.createQuery(hql).getResultList();
	}
}
