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
import prs.service.DoctorService;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@GetMapping("doctor/{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") Integer id) {
		DoctorDTO doctor = doctorService.getDoctor(id);
		return new ResponseEntity<DoctorDTO>(doctor, HttpStatus.OK);
	}
	@GetMapping("doctor/all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		List<DoctorDTO> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<DoctorDTO>>(doctors, HttpStatus.OK);
	}
	@GetMapping("doctor/sign_in/{username}")
	public ResponseEntity<Integer> logInDoctor(@PathVariable("username") String username) {
		Integer doctorID = doctorService.logInDoctor(username);
        return new ResponseEntity<Integer>(doctorID, HttpStatus.ACCEPTED);
	}
	@PostMapping("sign_up")
	public ResponseEntity<Void> registerDoctor(@RequestBody DoctorWrapper doctorWrapper, UriComponentsBuilder builder) {
		boolean isSuccess = doctorService.registerDoctor(doctorWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
	@PostMapping("doctor/update")
	public ResponseEntity<Void> updateArticle(@RequestBody Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
