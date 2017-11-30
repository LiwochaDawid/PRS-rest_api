package prs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import prs.entity.Patient;

@Repository
public class PatientDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	public Patient getPatientByID(int patientID) {
		return entityManager.find(Patient.class, patientID);
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatients() {
		String hql = "FROM Patient as patients ORDER BY patients.patientID";
		return (List<Patient>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Patient getPatientByAccountID(int accountID) {
		String hql = "FROM Patient as patients WHERE patients.account.accountID = ?";
		List<Patient> patient = entityManager.createQuery(hql)
				.setParameter(1, accountID).getResultList();
		return patient.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Patient getPatientByUsername(String username) {
		String hql = "FROM Patient as patients WHERE patients.account.username = ?";
		List<Patient> patient = entityManager.createQuery(hql)
				.setParameter(1, username).getResultList();
		return patient.get(0);
	}
	
	public void addPatient(Patient patient) {
		entityManager.persist(patient);
	}
	
	public void updatePatient(Patient newPatient) {
		Patient patient = getPatientByID(newPatient.getPatientID());
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
