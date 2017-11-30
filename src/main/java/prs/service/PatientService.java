package prs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.PatientDAO;
import prs.dto.PatientDTO;
import prs.entity.Patient;

@Transactional
@Service
public class PatientService {
	@Autowired 
	private PatientDAO patientDAO;
	
	public PatientDTO getPatientByID(int patientID) {
		PatientDTO patientDTO = new PatientDTO(patientDAO.getPatientByID(patientID));
		return patientDTO;
	}
	
	public PatientDTO getPatientByUsername(String username) {
		PatientDTO patientDTO = new PatientDTO(patientDAO.getPatientByUsername(username));
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
	
	public void updatePatient(Patient Patient) {
		patientDAO.updatePatient(Patient);
	}
}
