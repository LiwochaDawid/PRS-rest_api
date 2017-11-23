package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Patient;

@Repository
public class PatientDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public Patient getPatient(int patientID) {
		return entityManager.find(Patient.class, patientID);
	}
	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {
		String hql = "FROM Patient as patients ORDER BY patients.patientID";
		return (List<Patient>) entityManager.createQuery(hql).getResultList();
	}
	@SuppressWarnings("unchecked")
	public Patient getPatientByAccountID(int accountID) throws NonUniqueResultException {
		String hql = "FROM Patient as patients WHERE patients.accountID = ?";
		List<Patient> patient = entityManager.createQuery(hql)
				.setParameter(1, accountID).getResultList();
		if (patient.isEmpty()) {
			throw new NonUniqueResultException();
		}
		else {
			return patient.get(0);
		}
	}
	public void addPatient(Patient patient) {
		entityManager.persist(patient);
	}
	public void updatePatient(Patient newPatient) {
		Patient patient = getPatient(newPatient.getPatientID());
		patient.setName(newPatient.getName());
		patient.setSurname(newPatient.getSurname());
		patient.setStreet(newPatient.getStreet());
		patient.setPostcode(newPatient.getPostcode());
		patient.setCity(newPatient.getCity());
		patient.setCountry(newPatient.getCountry());
		patient.setPhoneNumber(newPatient.getPhoneNumber());
		entityManager.flush();
	}
}
