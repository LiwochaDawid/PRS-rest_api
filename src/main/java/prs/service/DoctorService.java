package prs.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.DoctorDAO;
import prs.dto.DoctorDTO;
import prs.entity.Account;
import prs.entity.Doctor;
import prs.model.DoctorWrapper;

@Transactional
@Service
public class DoctorService {
	@Autowired 
	private DoctorDAO doctorDAO;
	@Autowired 
	private AccountDAO accountDAO;
	public DoctorDTO getDoctor(int doctorID) {
		DoctorDTO doctorDTO = new DoctorDTO(doctorDAO.getDoctor(doctorID));
		return doctorDTO;
	}
	public List<DoctorDTO> getAllDoctors() {
		List<DoctorDTO> doctorsDTO = new ArrayList<>();
		List<Doctor> doctors = doctorDAO.getAllDoctors();
		for (int i=0; i<doctors.size(); i++) {
			doctorsDTO.add(new DoctorDTO(doctors.get(i)));
		}
		return doctorsDTO;
	}
	public int logInDoctor(String username) throws NonUniqueResultException {
		Account account = accountDAO.getAccount(username);
		int accountID = account.getAccountID();
		System.out.println("OLABOGA");
		System.out.println(accountID);
		Doctor doctor = doctorDAO.getDoctorByAccountID(accountID);
		return doctor.getDoctorID();		 
	}
	public synchronized boolean registerDoctor(DoctorWrapper doctorWrapper) {
		if (accountDAO.isAccountExists(doctorWrapper.getAccount())) {
			return false;
		}
		else {
			accountDAO.addAccount(doctorWrapper.getAccount());
			doctorWrapper.getDoctor().setAccount(doctorWrapper.getAccount());
			doctorDAO.addDoctor(doctorWrapper.getDoctor());
			return true;
		}
	}
	public void updateDoctor(Doctor doctor) {
		doctorDAO.updateDoctor(doctor);
	}
}
