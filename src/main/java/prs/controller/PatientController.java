package prs.controller;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import prs.dto.PatientDTO;
import prs.entity.Patient;
import prs.model.PatientWrapper;
import prs.model.LogInData;
import prs.service.PatientService;


@Controller
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	@GetMapping("{id}")
	public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Integer id) {
		PatientDTO patient = patientService.getPatient(id);
		return new ResponseEntity<PatientDTO>(patient, HttpStatus.OK);
	}
	@GetMapping("all")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = patientService.getAllPatients();
		return new ResponseEntity<List<PatientDTO>>(patients, HttpStatus.OK);
	}
	@PostMapping("account/sign_in")
	public ResponseEntity<Integer> logInPatient(@RequestBody LogInData logInData) {
		Integer patientID;
		try {
			patientID = patientService.logInPatient(logInData);
		} catch (NonUniqueResultException e) {
			patientID = 0;
		}
        if (patientID == 0) {
        	return new ResponseEntity<Integer>(patientID, HttpStatus.FORBIDDEN);
        }
        else {
        	return new ResponseEntity<Integer>(patientID, HttpStatus.ACCEPTED);
        }
	}
	@PostMapping("account/sign_up")
	public ResponseEntity<Void> registerPatient(@RequestBody PatientWrapper patientWrapper, UriComponentsBuilder builder) {
		boolean isSuccess = patientService.registerPatient(patientWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
	@PostMapping("update")
	public ResponseEntity<Void> updateArticle(@RequestBody Patient patient) {
		patientService.updatePatient(patient);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
