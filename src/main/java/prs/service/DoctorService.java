package prs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.DoctorDAO;
import prs.entity.Doctor;
import prs.wrapper.DoctorWrapper;

@Transactional
@Service
public class DoctorService {
	@Autowired 
	private DoctorDAO doctorDAO;
	@Autowired 
	private AccountDAO accountDAO;
	public Doctor getDoctor(int doctorID) {
		return doctorDAO.getDoctor(doctorID);
	}
	public List<Doctor> getAllDoctors() {
		return doctorDAO.getAllDoctors();
	}
	public synchronized boolean addDoctor(DoctorWrapper doctorWrapper) {
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
}
