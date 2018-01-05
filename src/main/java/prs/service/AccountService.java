package prs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.ConfigurationDAO;
import prs.dao.DoctorDAO;
import prs.dao.PatientDAO;
import prs.entity.Account;
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

    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
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
	
	public synchronized boolean changePassword(Account account, String pass) {
		Boolean passwordCorrent = BCrypt.checkpw(account.getPassword(), accountDAO.getAccountByUsername(account.getUsername()).getPassword());
		if (accountDAO.isUsernameExists(account) && passwordCorrent) {
			accountDAO.changePassword(account, pass);
			return true;
		}
		else {
			return false;
		}
	}

}
