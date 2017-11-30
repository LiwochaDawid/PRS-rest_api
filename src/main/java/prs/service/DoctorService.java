package prs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.AccountDAO;
import prs.dao.DoctorDAO;
import prs.dto.DoctorDTO;
import prs.entity.Doctor;


@Transactional
@Service
public class DoctorService {
	@Autowired 
	private DoctorDAO doctorDAO;
	
	public DoctorDTO getDoctorByID(int doctorID) {
		DoctorDTO doctorDTO = new DoctorDTO(doctorDAO.getDoctorByID(doctorID));
		return doctorDTO;
	}
	
	public DoctorDTO getDoctorByUsername(String username) {
		DoctorDTO doctorDTO = new DoctorDTO(doctorDAO.getDoctorByUsername(username));
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
	
	public void updateDoctor(Doctor doctor) {
		doctorDAO.updateDoctor(doctor);
	}
}
