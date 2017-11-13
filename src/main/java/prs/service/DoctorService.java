package prs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.DoctorDAO;
import prs.entity.Doctor;

@Transactional
@Service
public class DoctorService {
	@Autowired 
	private DoctorDAO doctorDAO;
	public List<Doctor> getAllDoctors() {
		return doctorDAO.getAllDoctors();
	}
}
