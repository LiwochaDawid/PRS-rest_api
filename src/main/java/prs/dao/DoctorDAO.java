package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Doctor;

@Repository
public class DoctorDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	public Doctor getDoctor(int doctorID) {
		return entityManager.find(Doctor.class, doctorID);
	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> getAllDoctors() {
		String hql = "FROM Doctor as doctors ORDER BY doctors.doctorID";
		return (List<Doctor>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Doctor getDoctorByAccountID(int accountID) throws NonUniqueResultException {
		String hql = "FROM Doctor as doctors WHERE doctors.accountID = ?";
		List<Doctor> doctor = entityManager.createQuery(hql)
				.setParameter(1, accountID).getResultList();
		if (doctor.isEmpty()) {
			throw new NonUniqueResultException();
		}
		else {
			return doctor.get(0);
		}
	}
	
	public void addDoctor(Doctor doctor) {
		entityManager.persist(doctor);
	}
	
	public void updateDoctor(Doctor newDoctor) {
		Doctor doctor = getDoctor(newDoctor.getDoctorID());
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
