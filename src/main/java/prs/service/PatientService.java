package prs.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.PatientDAO;
import prs.dto.PatientDTO;
import prs.entity.Account;
import prs.entity.Patient;
import prs.model.PatientWrapper;
import prs.model.LogInData;

@Transactional
@Service
public class PatientService {
	@Autowired 
	private PatientDAO patientDAO;
	@Autowired 
	private AccountDAO accountDAO;
	public PatientDTO getPatient(int patientID) {
		PatientDTO patientDTO = new PatientDTO(patientDAO.getPatient(patientID));
		return patientDTO;
	}
	
	public List<PatientDTO> getAllPatients() {
		List<PatientDTO> patientsDTO = new ArrayList<>();
		List<Patient> Patients = patientDAO.getAllPatients();
		for (int i=0; i<Patients.size(); i++) {
			patientsDTO.add(new PatientDTO(Patients.get(i)));
		}
		return patientsDTO;
	}
	
	public int logInPatient(LogInData logInData) throws NonUniqueResultException {
		Account account = accountDAO.getAccount(logInData);
		int accountID = account.getAccountID();
		Patient Patient = patientDAO.getPatientByAccountID(accountID);
		return Patient.getPatientID();		 
	}
	
	public synchronized boolean registerPatient(PatientWrapper PatientWrapper) {
		if (accountDAO.isAccountExists(PatientWrapper.getAccount())) {
			return false;
		}
		else {
			accountDAO.addAccount(PatientWrapper.getAccount());
			PatientWrapper.getPatient().setAccount(PatientWrapper.getAccount());
			patientDAO.addPatient(PatientWrapper.getPatient());
			return true;
		}
	}
	
	public void updatePatient(Patient Patient) {
		patientDAO.updatePatient(Patient);
	}
}
