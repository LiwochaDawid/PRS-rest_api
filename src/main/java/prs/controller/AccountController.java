package prs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import prs.model.DoctorWrapper;
import prs.model.PatientWrapper;
import prs.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("sign_up/doctor")
	public ResponseEntity<Void> registerDoctor(@RequestBody DoctorWrapper doctorWrapper) {
		boolean isSuccess = accountService.registerDoctor(doctorWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
	
	@PostMapping("sign_up/patient")
	public ResponseEntity<Void> registerPatient(@RequestBody PatientWrapper patientWrapper) {
		boolean isSuccess = accountService.registerPatient(patientWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
}
