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
	
	public Doctor getDoctorByID(int doctorID) {
		return entityManager.find(Doctor.class, doctorID);
	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> getAllDoctors() {
		String hql = "FROM Doctor as doctors ORDER BY doctors.doctorID";
		return (List<Doctor>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Doctor getDoctorByAccountID(int accountID) {
		String hql = "FROM Doctor as doctors WHERE doctors.account.accountID = ?";
		List<Doctor> doctor = entityManager.createQuery(hql)
				.setParameter(1, accountID).getResultList();
		return doctor.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Doctor getDoctorByUsername(String username) {
		String hql = "FROM Doctor as doctors WHERE doctors.account.username = ?";
		List<Doctor> doctor = entityManager.createQuery(hql)
				.setParameter(1, username).getResultList();
		return doctor.get(0);
	}
		
	public void addDoctor(Doctor doctor) {
		entityManager.persist(doctor);
	}
	
	public void updateDoctor(Doctor newDoctor) {
		Doctor doctor = getDoctorByID(newDoctor.getDoctorID());
		doctor.setName(newDoctor.getName());
		doctor.setSurname(newDoctor.getSurname());
		doctor.setPrefix(newDoctor.getPrefix());
		doctor.setStreet(newDoctor.getStreet());
		doctor.setPostcode(newDoctor.getPostcode());
		doctor.setCity(newDoctor.getCity());
		doctor.setCountry(newDoctor.getCountry());
		doctor.setPhoneNumber(newDoctor.getPhoneNumber());
		entityManager.flush();
	}
}
