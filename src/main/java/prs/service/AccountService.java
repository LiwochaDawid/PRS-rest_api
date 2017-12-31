package prs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.ConfigurationDAO;
import prs.dao.DoctorDAO;
import prs.dao.PatientDAO;
import prs.entity.Configuration;
import prs.model.DoctorWrapper;
import prs.model.PatientWrapper;

@Transactional
@Service
public class AccountService {
	@Autowired 
	private AccountDAO accountDAO;
	@Autowired 
	private DoctorDAO doctorDAO;
	@Autowired 
	private PatientDAO patientDAO;
	@Autowired 
	private ConfigurationDAO configurationDAO;
	
	public synchronized boolean registerDoctor(DoctorWrapper doctorWrapper) {
		if (accountDAO.isUsernameExists(doctorWrapper.getAccount())) {
			return false;
		}
		else {
			doctorWrapper.getAccount().setRole("ROLE_DOCTOR");
			doctorWrapper.getAccount().setEnabled(true);
			accountDAO.addAccount(doctorWrapper.getAccount());
			doctorWrapper.getDoctor().setAccount(doctorWrapper.getAccount());
			doctorDAO.addDoctor(doctorWrapper.getDoctor());
			Configuration configuration = new Configuration();
			configuration.setDefaultValues();
			configuration.setDoctor(doctorWrapper.getDoctor());
			configurationDAO.addConfiguration(configuration);
			return true;
		}
	}
	
	public synchronized boolean registerPatient(PatientWrapper patientWrapper) {
		if (accountDAO.isUsernameExists(patientWrapper.getAccount())) {
			return false;
		}
		else {
			patientWrapper.getAccount().setRole("ROLE_PATIENT");
			patientWrapper.getAccount().setEnabled(true);
			accountDAO.addAccount(patientWrapper.getAccount());
			patientWrapper.getPatient().setAccount(patientWrapper.getAccount());
			patientDAO.addPatient(patientWrapper.getPatient());
			return true;
		}
	}

}
