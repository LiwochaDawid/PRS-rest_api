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

import prs.dto.DoctorDTO;
import prs.entity.Doctor;
import prs.model.DoctorWrapper;
import prs.model.LogInData;
import prs.service.DoctorService;


@Controller
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@GetMapping("{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") Integer id) {
		DoctorDTO doctor = doctorService.getDoctor(id);
		return new ResponseEntity<DoctorDTO>(doctor, HttpStatus.OK);
	}
	@GetMapping("all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		List<DoctorDTO> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<DoctorDTO>>(doctors, HttpStatus.OK);
	}
	@PostMapping("account/sign_in")
	public ResponseEntity<Integer> logInDoctor(@RequestBody LogInData logInData) {
		Integer doctorID;
		try {
			doctorID = doctorService.logInDoctor(logInData);
		} catch (NonUniqueResultException e) {
			doctorID = 0;
		}
        if (doctorID == 0) {
        	return new ResponseEntity<Integer>(doctorID, HttpStatus.FORBIDDEN);
        }
        else {
        	return new ResponseEntity<Integer>(doctorID, HttpStatus.ACCEPTED);
        }
	}
	@PostMapping("account/sign_up")
	public ResponseEntity<Void> registerDoctor(@RequestBody DoctorWrapper doctorWrapper, UriComponentsBuilder builder) {
		boolean isSuccess = doctorService.registerDoctor(doctorWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
	@PostMapping("update")
	public ResponseEntity<Void> updateArticle(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
