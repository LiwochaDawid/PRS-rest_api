package prs.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import prs.dto.PatientDTO;
import prs.entity.Patient;
import prs.service.PatientService;


@Controller
@RequestMapping("patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("{id}")
	public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Integer id) {
		PatientDTO patient = patientService.getPatientByID(id);
		return new ResponseEntity<PatientDTO>(patient, HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = patientService.getAllPatients();
		return new ResponseEntity<List<PatientDTO>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("this")
    public ResponseEntity<PatientDTO> getCurrentPatient(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
		PatientDTO patient = patientService.getPatientByUsername(principal.getName());
		return new ResponseEntity<PatientDTO>(patient, HttpStatus.OK);
    }
	
	@PostMapping("update")
	public ResponseEntity<Void> updateArticle(@RequestBody Patient patient) {
		patientService.updatePatient(patient);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
